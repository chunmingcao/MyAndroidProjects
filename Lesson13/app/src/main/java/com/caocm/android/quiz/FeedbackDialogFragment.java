package com.caocm.android.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by caocm_000 on 12/10/2015.
 */
public class FeedbackDialogFragment extends DialogFragment {
    public interface ResultDialogListener{
        public void nextQuestion();
    }
    ResultDialogListener mListener;
    View layout;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();



        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        layout = inflater.inflate(R.layout.feedback_dialog, null);
        builder.setView(layout)
                // Add action buttons
                .setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mListener.nextQuestion();
                    }
                });
        TextView result = (TextView)layout.findViewById(R.id.result);
        result.setText("Very Good!!!");
        layout.findViewById(R.id.nextquestion).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        FeedbackDialogFragment.this.dismiss();
                        Toast.makeText(FeedbackDialogFragment.this.getActivity(),"######", Toast.LENGTH_LONG);
                        mListener.nextQuestion();
                    }
                }
        );
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mListener = (ResultDialogListener) activity;
    }
}
