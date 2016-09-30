package com.brendon.emphasistotext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EmphasisMain extends AppCompatActivity implements
EmphasisCheckboxFragment.EmpasisDialogListener{


    TextView mLabel;
    EditText mWordEntry;
    Button mOpenDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emphasis_main);

        mLabel = (TextView) findViewById(R.id.text_edit_label);
        mWordEntry = (EditText) findViewById(R.id.word_entry_field);
        mOpenDialog = (Button) findViewById(R.id.open_dialog_button);




    }
}
