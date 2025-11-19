package com.example.aichatbot;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
		bottomNav.setOnItemSelectedListener(item -> {
			Fragment target;
			int id = item.getItemId();
			if (id == R.id.nav_discover) {
				target = new DiscoverFragment();
			} else if (id == R.id.nav_chat) {
				target = new ChatFragment();
			} else if (id == R.id.nav_notifications) {
				target = new NotificationsFragment();
			} else if (id == R.id.nav_profile) {
				target = new ProfileFragment();
			} else {
				target = new DiscoverFragment();
			}
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, target)
					.commit();
			return true;
		});

		bottomNav.setSelectedItemId(R.id.nav_discover);
	}
}
