package com.rxjavademo.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.rxjavademo.R;
import javax.inject.Singleton;

@Singleton
  public class Util {
  private final boolean DEBUG = true;


        /**
         * This method is  Show toast message
         *
         * @param msg
         */
   public static void showToast(@NonNull Context context, @NonNull String msg) {

            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    public static String getDeviceId(Context context) {
        String device_id = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);

        Log.e("Device Id", "" + device_id);
        return device_id;
    }


        /**
         * Print log
         *
         * @param message
         */
    public void showLog(@NonNull String message) {
            if (DEBUG) {
                System.err.println(message);
            }
        }

        /**
         * Show Popup message
         *
         * @param context
         * @param title
         * @param message
         */
    public static void showBuilder(@NonNull Context context, @NonNull String title, @NonNull String message) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(title);
            builder.setMessage(message);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();
                }
            });

            builder.show();
        }

        /**
         * Check Network Connectivity
         *
         * @return
         */

        public static boolean isNetworkAvailable(Context context) {
            // Add a null check before you proceed
            if (context == null) return false;
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            @SuppressLint("MissingPermission") NetworkInfo info = cm.getActiveNetworkInfo();
            return info != null && info.isConnected() && info.isAvailable();


        }


        public static void dismissKeyboard(Activity activity) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (null != activity.getCurrentFocus())
                imm.hideSoftInputFromWindow(activity.getCurrentFocus()
                        .getApplicationWindowToken(), 0);
        }



    public static void showErrorMessageDialog(final Activity mActivity, final String heading ,final String title,final OnDialogOkClickListener onDialogOkClickListener) {
        try {

            Dialog mDialogLogout;
            mDialogLogout = new Dialog(mActivity);
            mDialogLogout.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mDialogLogout.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            mDialogLogout.setContentView(R.layout.dialog_success);
            mDialogLogout.setCancelable(false);
            TextView tvtitleHeading = mDialogLogout.findViewById(R.id.title_error);
            tvtitleHeading.setText(heading);
            TextView tvtitle = mDialogLogout.findViewById(R.id.title_error_msg);
            tvtitle.setText(title);
            TextView mTvOK = mDialogLogout.findViewById(R.id.tv_ok);
            mTvOK.setOnClickListener(v -> {
                if (onDialogOkClickListener != null) {
                    onDialogOkClickListener.onOkButtonClicked();
                }
                mDialogLogout.dismiss();

            });

            mDialogLogout.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public interface OnDialogOkClickListener {
        void onOkButtonClicked();
    }

    public static void showSucesseDialog(final Activity mActivity, final String heading ,final String title,final OnDialogOkClickListener onDialogOkClickListener) {
        try {

            Dialog mDialogLogout;
            mDialogLogout = new Dialog(mActivity);
            mDialogLogout.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mDialogLogout.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            mDialogLogout.setContentView(R.layout.dialog_success);
            mDialogLogout.setCancelable(false);
            TextView tvtitleHeading = mDialogLogout.findViewById(R.id.title_error);
            tvtitleHeading.setText(heading);
            TextView tvtitle = mDialogLogout.findViewById(R.id.title_error_msg);
            tvtitle.setText(title);
            TextView mTvOK = mDialogLogout.findViewById(R.id.tv_ok);
            mTvOK.setOnClickListener(v -> {
                if (onDialogOkClickListener != null) {
                    onDialogOkClickListener.onOkButtonClicked();
                }
                mDialogLogout.dismiss();

            });

            mDialogLogout.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
