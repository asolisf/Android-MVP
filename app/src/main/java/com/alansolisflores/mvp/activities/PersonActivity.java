package com.alansolisflores.mvp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.alansolisflores.mvp.R;
import com.alansolisflores.mvp.helpers.Constants;
import com.alansolisflores.mvp.contracts.PersonContract;
import com.alansolisflores.mvp.presenters.PersonPresenter;

public class PersonActivity extends AppCompatActivity implements PersonContract.View,
        View.OnClickListener{

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private TextView totalTextView;
    private Button saveButton;
    private PersonPresenter personPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        initViews();
        personPresenter = new PersonPresenter(this);
    }

    private void initViews() {
        this.firstNameEditText = findViewById(R.id.firstNameEditText);
        this.lastNameEditText = findViewById(R.id.lastNameEditText);
        this.totalTextView = findViewById(R.id.totalTextView);
        this.saveButton = findViewById(R.id.saveButton);

        this.saveButton.setOnClickListener(this);
    }

    private void clearForm()
    {
        this.firstNameEditText.setText(Constants.STRING_EMPTY);
        this.lastNameEditText.setText(Constants.STRING_EMPTY);
    }

    @Override
    public void ShowMessage(String message) {
        Toast.makeText(PersonActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void ShowTotal(String total) {
        totalTextView.setText(total);
    }

    @Override
    public void onClick(View view) {
        personPresenter.AddPerson(firstNameEditText.getText().toString(),
                                  lastNameEditText.getText().toString());
        clearForm();
    }
}
