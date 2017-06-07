package zorail.rohan.com.unittesting;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

/**
 * Created by zorail on 07-Jun-17.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {
    MainActivity activity;

    @Before
    public void setUp() throws Exception{
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .start()
                .resume()
                .get();
    }

    @Test
    public void editTextUpdatesTextView() throws Exception{
        //Arrange
        String givenString = "test123";
        activity.editText.setText(givenString);

        //Act
        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        //Assert
        String actualString = activity.textView.getText().toString();
        assertEquals(givenString,actualString);
    }
    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception{
        //Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        //Act
        activity.colorSpinner.setSelection(index);

        //Assert
        int expectedColor = ((ColorDrawable)activity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor,expectedColor);
    }
    @Test
    public void buttonLaunchesOtherActivity() throws Exception{
        //Arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(activity,clazz);

        //Act
        activity.launchActivityButton.callOnClick();

        //Assert
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent realIntent = shadowActivity.getNextStartedActivity();
        assertTrue(expectedIntent.filterEquals(realIntent));
    }

}
