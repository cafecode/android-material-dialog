package me.cafecode.android.material.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Natthawut Hemathulin on 2/26/15 AD.
 * Email: natthawut1991@gmail.com
 */
public class MaterialDialog extends AlertDialog {

    /*public MaterialDialog(Context context) {
        super(context);
    }*/

    /**
     * Views in dialog
     */
    private View mDialogView;
    private TextView mTitleTextView;
    private TextView mMessageTextView;

    private Context context;

    private Builder builder;

    private String title;
    private String message;

    public static class Builder {

        private Context mContext;

        private String title;
        private String message;

        public Builder(Context context) {
            mContext = context;
        }

        public Context getContext() {
            return mContext;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder title(@StringRes int titleRes) {
            this.title = mContext.getString(titleRes);
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder message(@StringRes int messageRes) {
            this.message = mContext.getString(messageRes);
            return this;
        }

        public MaterialDialog create() {
            return new MaterialDialog(this);
        }

        public MaterialDialog show() {
            MaterialDialog materialDialog = create();
            materialDialog.show();
            return materialDialog;
        }

        /*public Builder(Context context, int theme) {
            super(context, theme);
        }*/

    }

    public MaterialDialog(Builder builder) {
        super(builder.getContext());

        this.builder = builder;
        this.context = builder.getContext();

        this.title = builder.title;
        this.message = builder.message;

        mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_base, null);

        mTitleTextView = (TextView) mDialogView.findViewById(R.id.title_text);
        mMessageTextView = (TextView) mDialogView.findViewById(R.id.message_text);

        if (this.title != null) {
            mTitleTextView.setText(this.title);
        }
        if (this.message != null) {
            mMessageTextView.setText(this.message);
        }

        super.setView(mDialogView);
    }

    public MaterialDialog(Context context, int theme) {
        super(context, theme);
    }

    protected MaterialDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

}
