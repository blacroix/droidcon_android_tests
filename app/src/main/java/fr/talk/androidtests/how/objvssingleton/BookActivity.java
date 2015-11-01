package fr.talk.androidtests.how.objvssingleton;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.TextView;

import fr.talk.androidtests.R;

public class BookActivity extends Activity {

    @VisibleForTesting
    TextView bookTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookTextView = (TextView) findViewById(R.id.bookTextView);
    }

    public void updateBookName() {
        String name = LibrarySingleton.getInstance().getName();
        if (name == null) {
            bookTextView.setVisibility(View.GONE);
        } else {
            bookTextView.setVisibility(View.VISIBLE);
            bookTextView.setText(name);
        }
    }
}
