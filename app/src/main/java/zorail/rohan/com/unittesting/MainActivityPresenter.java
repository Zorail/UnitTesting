package zorail.rohan.com.unittesting;

import android.graphics.Color;

import javax.inject.Inject;

/**
 * Created by zorail on 06-Jun-17.
 */

public class MainActivityPresenter {
    MainActivityView view;

    public MainActivityPresenter(MainActivityView view){
        this.view = view;
    }
    public void editTextUpdated(String text){
        view.changeTextViewText(text);
    }
    public void colorSelected(int index){
        switch (index) {
            case 0:
                view.changeBackgroundColor(Color.WHITE);
                break;
            case 1:
                view.changeBackgroundColor(Color.MAGENTA);
                break;
            case 2:
                view.changeBackgroundColor(Color.GREEN);
                break;
            case 3:
                view.changeBackgroundColor(Color.CYAN);
                break;
        }
    }
    public void otherActivityLaunchButtonCLicked(Class activity){
        view.launchOtherActivity(activity);
    }
}
