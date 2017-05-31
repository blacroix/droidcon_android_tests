package fr.talk.androidtests.improve.assertjandroid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import fr.talk.androidtests.R;

public class TestableCustomView extends LinearLayout {

    TextView messageView;
    TextView errorView;

    public TestableCustomView(Context context) {
        this(context, null);
    }

    public TestableCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestableCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOrientation(VERTICAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(getContext()).inflate(R.layout.testable_custom_view_content, this, true);
        messageView = (TextView) findViewById(R.id.message);
        errorView = (TextView) findViewById(R.id.error);
    }

    public void showMessage(String message) {
        messageView.setText(message);
        messageView.setVisibility(VISIBLE);
        errorView.setVisibility(GONE);
    }
}
