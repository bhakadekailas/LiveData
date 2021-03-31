package bhakadekailas.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate: ");

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
//        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        MutableLiveData<String> randomNumber = viewModel.getNumber();

        randomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e(TAG, "onChanged: ");
                textView.setText(s);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.createNumber();
            }
        });
    }
}