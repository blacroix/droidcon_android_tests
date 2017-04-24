package fr.talk.androidtests.how.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fr.talk.androidtests.R;

public class FormActivity extends Activity {

    @VisibleForTesting
    EditText loginEditText;

    @VisibleForTesting
    EditText passwordEditText;

    @VisibleForTesting
    Button connectButton;

    //region mvp
    FormPresenter presenter = new FormPresenter(this);
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        loginEditText = (EditText) findViewById(R.id.loginEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        connectButton = (Button) findViewById(R.id.connectButton);

        connectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkForm();
            }
        });

        setStateLoginNeeded();
    }

    void setStateLoginNeeded() {
        loginEditText.setEnabled(true);
        passwordEditText.setEnabled(true);
        connectButton.setEnabled(true);
    }

    void setStateLogged() {
        loginEditText.setEnabled(false);
        passwordEditText.setEnabled(false);
        connectButton.setEnabled(false);
    }

    private void checkForm() {
        //region no mvp
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if (isValid(login) && isValid(password)) {
            Toast.makeText(this, R.string.toast_success_login, Toast.LENGTH_SHORT).show();
            setStateLogged();
        }
        //endregion

        //region mvp
        presenter.checkForm(loginEditText.getText().toString(), passwordEditText.getText().toString());
        //endregion
    }

    //region no mvp
    private boolean isValid(String text) {
        return text != null && text.length() > 3;
    }
    //endregion
}
