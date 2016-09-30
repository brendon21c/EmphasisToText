package com.brendon.emphasistotext;


import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class EmphasisCheckboxFragment extends DialogFragment{

    private static final String STRING_KEY = "word key";

    CheckBox mCapital;
    CheckBox mExclimation;
    CheckBox mSmileyFace;

    private String mUserPhrase;


    private EmpasisDialogListener mEmphasis; // Listener variable.


    interface EmpasisDialogListener {

        //TODO add in information for options.

    }



    // Sets up the fragment and passes in the User string.
    public static EmphasisCheckboxFragment newInstance(String word) {


        Bundle bundle = new Bundle();
        bundle.putString(STRING_KEY, word);


        EmphasisCheckboxFragment fragment = new EmphasisCheckboxFragment();
        //mUserPhrase = word;
        fragment.setArguments(bundle);
        return fragment;

    }

    // Overides the listener when the dialog is called.
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof EmpasisDialogListener) {

            mEmphasis = (EmpasisDialogListener) activity;

        } else {

            throw new RuntimeException(activity.toString() + " Must be a instance of EmphasisListener");

        }

    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        mUserPhrase = getArguments().getString(STRING_KEY);

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select one or more options.");
        builder.setCancelable(true);


        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View view = inflater.inflate(R.layout.emphasis_checkbox_dialog, null);
        builder.setView(view); // inflates the window.

        mCapital = (CheckBox) view.findViewById(R.id.capital_checkbox);
        mExclimation = (CheckBox) view.findViewById(R.id.exclamation_checkbox);
        mSmileyFace = (CheckBox) view.findViewById(R.id.smileyface_checkbox);


        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(getActivity(), mUserPhrase, Toast.LENGTH_SHORT).show();

            }
        });

        // Closes the dialog box
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.cancel();

            }
        });


        return builder.create();

    }
}
