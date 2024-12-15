package com.example.homework_3_2;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ResultFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView tvResult = view.findViewById(R.id.tv_counter);

        Bundle args = getArguments();
        if (args != null) {
            int counterValue = args.getInt("counter_value", 0);
            tvResult.setText(String.valueOf(counterValue));
        } else {
            tvResult.setText("Not found");
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        NavController navController = NavHostFragment.findNavController(ResultFragment.this);
                        if (navController.getPreviousBackStackEntry() != null) {
                            Log.d("ResultFragment", "Navigating up");
                            navController.navigateUp();
                        } else {
                            Log.d("ResultFragment", "No previous back stack, finishing activity");
                            requireActivity().finish();
                        }
                    }
                });
    }


}
