# BottomSheetExample
A sample project with the new BottomSheet classes from the android support library

For a simpler integration, consider using this: https://github.com/rubensousa/BottomSheetBuilder

## Modes included

- Simple view (A LinearLayout is used in this sample)
- BottomSheetDialog

## Simple view how-to

- Place a new view as a direct child of CoordinatorLayout (preferably as the last one, so it lays on top of all other views)
- Set it's behavior to:

        app:layout_behavior="@string/bottom_sheet_behavior"
        
## Known issues
- BottomSheetBehavior setState method doesn't work before the BottomSheet is expanded for a first time: https://code.google.com/p/android/issues/detail?id=201825
- BottomSheetDialog stops being aligned to the bottom: https://code.google.com/p/android/issues/detail?id=201826

## Screenshots
<img src="screens/screen-view.png" width="350"> <img src="screens/screen-dialog.png" width="350">

## Dependencies

    compile 'com.android.support:appcompat-v7:23.2.0'
    compile 'com.android.support:design:23.2.0'
