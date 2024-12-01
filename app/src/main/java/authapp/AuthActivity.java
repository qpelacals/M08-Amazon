package authapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.m08_amazon.R;

import authapp.LoginFragment;
import authapp.RegisterFragment;

public class AuthActivity extends AppCompatActivity {

    public static final String AUTH_MODE_LOGIN = "login";
    public static final String AUTH_MODE_REGISTER = "register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        // Obtener el modo de autenticación desde el Intent
        String authMode = getIntent().getStringExtra("auth_mode");

        if (savedInstanceState == null) {
            if (AUTH_MODE_REGISTER.equals(authMode)) {
                loadFragment(new RegisterFragment());
            } else {
                // Por defecto, carga el fragmento de login
                loadFragment(new LoginFragment());
            }
        }
    }

    public void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}


