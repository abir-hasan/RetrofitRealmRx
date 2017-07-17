package me.abir.retrofitrealm.git_hub_example.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.widget.Toast;

import me.abir.retrofitrealm.R;
import me.abir.retrofitrealm.databinding.DialogCredentialsBinding;

/**
 * Created by Abir on 17-Jul-17.
 */

public class CredentialsDialog extends DialogFragment {

    private CredentialHandler handler;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final FragmentActivity activity = getActivity();
        final DialogCredentialsBinding bindingUtil = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.dialog_credentials, null, false);

        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(bindingUtil.getRoot());
        builder.setTitle("Put Your Credentials");
        builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (handler != null) {
                    handler.onCredentialInput(bindingUtil.etUserName.getText().toString(), bindingUtil.etPassWord.getText().toString());
                }
                dismiss();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }

    public void setCredentialHandler(CredentialHandler handler) {
        this.handler = handler;
    }


    interface CredentialHandler {
        void onCredentialInput(String userName, String passWord);
    }
}
