package com.lisway.transport.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

public final class ViewUtil {

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getWindow().getDecorView().getWindowToken(), 0);
    }

    public static boolean onEditorDoneAction(int actionId, View performView, Activity activity) {
        boolean isConsumed = false;
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH) {
            isConsumed = true;
            hideKeyboard(activity);
            performView.performClick();
        }
        return isConsumed;
    }
}
