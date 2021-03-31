package bhakadekailas.livedata;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class MainActivityViewModel extends ViewModel {

    private static final String TAG = MainActivityViewModel.class.getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber() {
        Log.e(TAG, "getNumber: ");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {
        Log.e(TAG, "createNumber: ");
        Random random = new Random();
        myRandomNumber.setValue("Random Number is = " + (random.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e(TAG, "onCleared: ");
    }
}
