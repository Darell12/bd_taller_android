package com.example.agenda;

import android.app.Activity;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Navegacion {

    public static void setupBottomNavigation(Activity activity) {
        BottomNavigationView bottomNavigationView = activity.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                item -> {
                    if (item.getItemId() == R.id.action_crear) {
                        activity.startActivity(new Intent(activity, ListarContactosActivity.class));
                        return true;
                    } else if (item.getItemId() == R.id.action_crear) {
                        activity.startActivity(new Intent(activity, NewActivity.class));
                        return true;
                    } else if (item.getItemId() == R.id.action_home) {
                        activity.startActivity(new Intent(activity, MainActivity.class));
                        return true;
                    } else {
                        return false; // Cambiado de super.onOptionsItemSelected(item) a false
                    }
                }
        );
    }

}
