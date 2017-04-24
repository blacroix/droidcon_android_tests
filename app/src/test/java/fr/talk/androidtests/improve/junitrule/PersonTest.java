package fr.talk.androidtests.improve.junitrule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;

//region
@RunWith(RobolectricTestRunner.class)
//endregion
public class PersonTest {

    //region ExpectedException
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void should_throw_exception_for_negative_age() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Age must be positive");

        // When
        new Person(-1);
    }
    //endregion

    //region Rule Mockito and Robolectric
    @Rule
    public InitMockAnnotationsRule mockRule =  new InitMockAnnotationsRule(this);

    @Mock
    Person person;

    @Test
    public void test_mock() throws Exception {
        when(person.getAge()).thenReturn(1);

        assertThat(person.getAge()).isEqualTo(1);
    }

    static class InitMockAnnotationsRule implements TestRule {
        private final Object target;

        InitMockAnnotationsRule(Object target) {
            this.target = target;
        }

        @Override
        public Statement apply(final Statement base, Description description) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    MockitoAnnotations.initMocks(target);
                    base.evaluate();
                }
            };
        }
    }
    //endregion
}