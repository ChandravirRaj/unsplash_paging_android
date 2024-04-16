package com.androboy.unsplashpaging.utils;

import android.widget.Button;

import androidx.appcompat.app.AlertDialog;

import com.androboy.unsplashpaging.R;
import com.androboy.unsplashpaging.ui.BaseActivity;

/**
 * Show all dialog all over the application
 */
public class DialogUtils {

    /**
     * Constructor
     */
    private DialogUtils() {
    }


    /**
     * Method is used to show alert dialog
     *
     * @param context activity context
     * @param message to show in dialog
     */
    public static void showAlert(BaseActivity context, String message) {
        if (context != null && !context.isFinishing()) {
            showAlert(context, context.getResources().getString(R.string.app_name), message, context.getResources().getString(R.string.ok), context.getResources().getString(R.string.cancel));
        }
    }

    /**
     * Method is used to show alert dialog
     *
     * @param context  activity context
     * @param message  to show in dialog
     * @param callback dialog callback once click on yes no
     */
    public static void showAlert(BaseActivity context, String message, IDialogCallback callback) {
        if (context != null && !context.isFinishing()) {
            showAlert(context, context.getResources().getString(R.string.app_name), message, context.getResources().getString(R.string.ok), context.getResources().getString(R.string.cancel), callback);
        }
    }

    /**
     * Method is used to show alert dialog
     *
     * @param context activity context
     * @param message to show in dialog
     * @param ok      action name on yes button
     * @param no      action name on no button
     */
    public static void showAlert(BaseActivity context, String title, String message, String ok, String no) {
        if (context != null && !context.isFinishing()) {
            showAlert(context, title, message, ok, no, null);
        }
    }

    /**
     * Method is used to show alert dialog
     *
     * @param context  activity context
     * @param message  to show in dialog
     * @param ok       action name on yes button
     * @param no       action name on no button
     * @param callback dialog callback once click on yes no
     * @param title    title of dialog
     */
    public static void showAlert(BaseActivity context, String title, String message, String ok, String no, final IDialogCallback callback) {
        if (context != null && !context.isFinishing()) {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle(title).setMessage(message)
                    .setPositiveButton(ok, (dialog1, which) -> {
                        if (callback != null) {
                            callback.onClick(true);
                        }
                    })
                    .setNegativeButton(no, (dialog12, which) -> {
                        if (callback != null) {
                            callback.onClick(false);
                        }
                    }).show();
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            positiveButton.setTextColor(AppUtil.getColor(R.color.black));
            negativeButton.setTextColor(AppUtil.getColor(R.color.black));
        }
    }


    public static void showAlert(BaseActivity context, String title, String message,
                                 String ok, String no, boolean cancelable, final IDialogCallback callback) {

        if (context != null && !context.isFinishing()) {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setCancelable(cancelable)
                    .setPositiveButton(ok, (dialog1, which) -> {
                        if (callback != null) {
                            callback.onClick(true);
                        }
                    })
                    .setNegativeButton(no, (dialog12, which) -> {
                        if (callback != null) {
                            callback.onClick(false);
                        }
                    }).show();
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            positiveButton.setTextColor(AppUtil.getColor(R.color.black));
            negativeButton.setTextColor(AppUtil.getColor(R.color.black));
        }
    }


    /**
     * Method is used to show alert dialog without no action button
     *
     * @param context  activity context
     * @param message  to show in dialog
     * @param ok       action name on yes button
     * @param callback dialog callback once click on yes no
     * @param title    title of dialog
     */
    public static void showAlert(BaseActivity context, String title, String message, String ok, final IDialogCallback callback) {
        if (context != null && !context.isFinishing()) {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setOnDismissListener(dialog1 -> {
                        if (callback != null) {
                            callback.onClick(true);
                        }
                    })
                    .setOnCancelListener(dialog12 -> {
                        if (callback != null) {
                            callback.onClick(true);
                        }
                    })
                    .setPositiveButton(ok, (dialog13, which) -> {
                        if (callback != null) {
                            callback.onClick(true);
                        }
                    }).show();
            dialog.setCanceledOnTouchOutside(false);
            Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            positiveButton.setTextColor(AppUtil.getColor(R.color.black));
        }
    }


}

