package de.neosimsim.errordialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class ErrorDialogFragment extends DialogFragment {
    private AndroidError error;
    private OnErrorConfirmedListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(error.getTitle(getActivity()))
                .setMessage(error.getMessage(getActivity()))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onErrorConfirmed(error);
                        }
                    }
                });

        return builder.create();
    }

    public void setError(AndroidError error) {
        this.error = error;
    }

    public void setListener(OnErrorConfirmedListener listener) {
        this.listener = listener;
    }

}
