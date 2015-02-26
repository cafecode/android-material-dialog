package me.cafecode.android.material.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Natthawut Hemathulin on 2/26/15 AD.
 * Email: natthawut1991@gmail.com
 */
public class MaterialDialog extends AlertDialog {

    /*public MaterialDialog(Context context) {
        super(context);
    }*/

    private Context context;
    private Builder builder;

    public static class Builder {

        private Context mContext;

        public Builder(Context context) {
            mContext = context;
        }

        public Context getContext() {
            return mContext;
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

        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_base, null);
        super.setView(contentView);
    }

    public MaterialDialog(Context context, int theme) {
        super(context, theme);
    }

    protected MaterialDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }



}
