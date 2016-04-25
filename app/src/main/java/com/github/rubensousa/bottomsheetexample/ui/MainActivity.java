package com.github.rubensousa.bottomsheetexample.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.rubensousa.bottomsheetexample.R;
import com.github.rubensousa.bottomsheetexample.ui.adapter.Item;
import com.github.rubensousa.bottomsheetexample.ui.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemAdapter.ItemListener, View.OnClickListener {


    private ItemAdapter mAdapter;
    private BottomSheetBehavior mBehavior;
    private View mBottomSheet;
    private BottomSheetDialog mBottomSheetDialog;
    private BottomSheetBehavior mDialogBehavior;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        findViewById(R.id.showViewBtn).setOnClickListener(this);
        findViewById(R.id.showDialogBtn).setOnClickListener(this);
        findViewById(R.id.showDialogFullscreenBtn).setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            findViewById(R.id.fakeShadow).setVisibility(View.GONE);
        }

        mBottomSheet = findViewById(R.id.bottomSheet);
        mBehavior = BottomSheetBehavior.from(mBottomSheet);

        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ItemAdapter(createItems(), this);
        recyclerView.setAdapter(mAdapter);

        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.setListener(null);
    }

    public List<Item> createItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.ic_preview_24dp, "Preview"));
        items.add(new Item(R.drawable.ic_share_24dp, "Share"));
        items.add(new Item(R.drawable.ic_link_24dp, "Get link"));
        items.add(new Item(R.drawable.ic_content_copy_24dp, "Copy"));
        return items;
    }

    @Override
    public void onItemClick(Item item) {
        mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.showViewBtn) {
            showBottomSheetView();
        }

        if (v.getId() == R.id.showDialogBtn) {
            showBottomSheetDialog();
        }

        if (v.getId() == R.id.showDialogFullscreenBtn) {
            showBottomSheetDialogFullscreen();
        }
    }

    private void showBottomSheetView() {
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        if (mBottomSheetDialog != null) {
            mBottomSheetDialog.dismiss();
        }
    }

    @SuppressLint("InflateParams")
    private void showBottomSheetDialog() {
        if (mBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        View view = getLayoutInflater().inflate(R.layout.sheet, null);
        view.findViewById(R.id.fakeShadow).setVisibility(View.GONE);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(createItems(), new ItemAdapter.ItemListener() {
            @Override
            public void onItemClick(Item item) {
                mDialogBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        }));

        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setContentView(view);
        mDialogBehavior = BottomSheetBehavior.from((View) view.getParent());

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }

    private void showBottomSheetDialogFullscreen() {
        new FullBottomSheetDialogFragment().show(getSupportFragmentManager(), "dialog");
    }
}
