package fr.talk.androidtests.how.compositionvsinheritance;

import android.content.Context;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import fr.talk.androidtests.R;

public abstract class BaseView extends LinearLayout {

    TextView nameTextView;

    public BaseView(Context context) {
        this(context, null);
    }

    public BaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(getContext(), R.layout.custom_view, this);

        nameTextView = (TextView) findViewById(R.id.nameTextView);
    }

    public void updateName(Profile profile) {
        if (profile == null) {
            nameTextView.setVisibility(GONE);
        } else {
            nameTextView.setVisibility(VISIBLE);
        }
    }

    public void showMessage(@StringRes int messageId) {
        Toast.makeText(getContext(), messageId, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
