# BottomSheetExample
A sample project with the new BottomSheet classes from the android support library


## Modes included

- Simple view (A cardview is used in this sample)
- BottomSheetDialog

## Simple view how-to

- Place a new view as a direct child of CoordinatorLayout (preferably as the last one, so it lays on top of all other views)
- Set it's behavior to:

        app:layout_behavior="@string/bottom_sheet_behavior"

## Screenshots
<img src="screens/screen-view.png" width="350"> <img src="screens/screen-dialog.png" width="350">

## Dependencies

    compile 'com.android.support:appcompat-v7:23.2.0'
    compile 'com.android.support:design:23.2.0'
    compile 'com.android.support:cardview-v7:23.2.0'
