package zorail.rohan.com.unittesting;

/**
 * Created by zorail on 06-Jun-17.
 */

public interface MainActivityView {
    void changeTextViewText(String text);
    void changeBackgroundColor(int color);
    void launchOtherActivity(Class activity);
}
