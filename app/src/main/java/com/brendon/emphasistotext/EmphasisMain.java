package com.brendon.emphasistotext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmphasisMain extends AppCompatActivity implements
EmphasisCheckboxFragment.EmpasisDialogListener{


    TextView mLabel;
    EditText mWordEntry;
    Button mOpenDialog;

    String mUserPhrase;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emphasis_main);

        mLabel = (TextView) findViewById(R.id.text_edit_label);
        mWordEntry = (EditText) findViewById(R.id.word_entry_field);
        mOpenDialog = (Button) findViewById(R.id.open_dialog_button);


        // Starts the dialog box.
        mOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mUserPhrase = mWordEntry.getText().toString();
                mWordEntry.setText("");


                EmphasisCheckboxFragment emphasisDialog = EmphasisCheckboxFragment.newInstance(mUserPhrase);
                emphasisDialog.show(getFragmentManager(), "show dialog");

            }
        });


    }




}
