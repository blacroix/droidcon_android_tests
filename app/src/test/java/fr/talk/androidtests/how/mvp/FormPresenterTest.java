package fr.talk.androidtests.how.mvp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import fr.talk.androidtests.R;
import fr.talk.androidtests.how.compositionvsinheritance.Messenger;

//region @RunWith
@RunWith(MockitoJUnitRunner.class)
//endregion
public class FormPresenterTest {

    //region Mock annotation
    @Mock FormActivity activity;
    @Mock Messenger messenger;
    //endregion

    //region Mock injection
    @InjectMocks
    FormPresenter presenter;
    //endregion

    @Test
    public void should_be_valid() throws Exception {
        // Given

        // When
        presenter.checkForm("john", "powered");

        // Then
        //region showMessage()
        Mockito.verify(messenger).showMessage(R.string.toast_success_login);
        //endregion

        //region setStateLogged()
        Mockito.verify(activity).setStateLogged();
        //endregion
    }

    @Test
    public void should_be_invalid_cause_login() throws Exception {
        // Given

        // When
        presenter.checkForm("a", "powered");

        // Then
        //region verifyZeroInteractions()
        Mockito.verifyZeroInteractions(messenger);
        //endregion

        //region setStateLoginNeeded()
        Mockito.verify(activity).setStateLoginNeeded();
        //endregion
    }
}