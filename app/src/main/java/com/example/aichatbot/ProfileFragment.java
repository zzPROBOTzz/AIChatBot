package com.example.aichatbot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_profile, container, false);
		Button logout = view.findViewById(R.id.button_logout);
		logout.setOnClickListener(v -> {
			Toast.makeText(requireContext(), "Logout placeholder", Toast.LENGTH_SHORT).show();
		});
		return view;
	}
}
