package com.example.homework_3_2;
import static com.example.homework_3_2.R.*;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CounterFragment extends Fragment {
    private int counter = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_counter, container, false);
        TextView tvCounter = view.findViewById(R.id.tv_counter);
        Button btnIncrement = view.findViewById(R.id.btn_Increment);
        Button btnNavigate = view.findViewById(R.id.btn_navigate);
        btnIncrement.setOnClickListener(v -> {
            counter++;
            tvCounter.setText(String.valueOf(counter));

        });
        btnNavigate.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("counter_value", counter);
            Log.d("CounterFragment", "Passing counter value: " + counter);
            {
                NavHostFragment.findNavController(CounterFragment.this)
                        .navigate(id.action_counter_to_result, bundle);


            }
        });
        return view;
    }
}