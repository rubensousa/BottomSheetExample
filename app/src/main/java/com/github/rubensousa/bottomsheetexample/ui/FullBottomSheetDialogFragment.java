package com.github.rubensousa.bottomsheetexample.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.rubensousa.bottomsheetexample.R;
import com.github.rubensousa.bottomsheetexample.ui.adapter.Item;
import com.github.rubensousa.bottomsheetexample.ui.adapter.ItemAdapter;

import java.util.ArrayList;
import java.util.List;


public class FullBottomSheetDialogFragment extends BottomSheetDialogFragment
        implements ItemAdapter.ItemListener {

    private BottomSheetBehavior mBehavior;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        View view = View.inflate(getContext(), R.layout.sheet, null);

        view.findViewById(R.id.fakeShadow).setVisibility(View.GONE);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ItemAdapter itemAdapter = new ItemAdapter(createItems(), this);
        recyclerView.setAdapter(itemAdapter);

        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    public List<Item> createItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(R.drawable.ic_preview_24dp, "Preview"));
        items.add(new Item(R.drawable.ic_share_24dp, "Share"));
        items.add(new Item(R.drawable.ic_link_24dp, "Get link"));
        items.add(new Item(R.drawable.ic_content_copy_24dp, "Copy"));
        items.add(new Item(R.drawable.ic_preview_24dp, "Preview"));
        items.add(new Item(R.drawable.ic_share_24dp, "Share"));
        items.add(new Item(R.drawable.ic_link_24dp, "Get link"));
        items.add(new Item(R.drawable.ic_content_copy_24dp, "Copy"));
        items.add(new Item(R.drawable.ic_preview_24dp, "Preview"));
        items.add(new Item(R.drawable.ic_share_24dp, "Share"));
        items.add(new Item(R.drawable.ic_link_24dp, "Get link"));
        items.add(new Item(R.drawable.ic_content_copy_24dp, "Copy"));
        items.add(new Item(R.drawable.ic_preview_24dp, "Preview"));
        items.add(new Item(R.drawable.ic_share_24dp, "Share"));
        items.add(new Item(R.drawable.ic_link_24dp, "Get link"));
        items.add(new Item(R.drawable.ic_content_copy_24dp, "Copy"));
        return items;
    }

    @Override
    public void onItemClick(Item item) {
        mBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}
