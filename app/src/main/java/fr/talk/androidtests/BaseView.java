package fr.talk.androidtests;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

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
}
