package authapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.m08_amazon.R;

public class LoginFragment extends Fragment {

    public LoginFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        EditText editEmail = view.findViewById(R.id.edit_email);
        EditText editPassword = view.findViewById(R.id.edit_password);
        Button btnLogin = view.findViewById(R.id.btn_login);
        TextView txtRegister = view.findViewById(R.id.txt_register);
        TextView txtForgotPassword = view.findViewById(R.id.txt_forgot_password);

        btnLogin.setOnClickListener(v -> {
            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();

            // Lógica de autenticación
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí puedes reemplazarlo por una validación con una API o base de datos
                if (email.equals("user@example.com") && password.equals("password123")) {
                    // Iniciar sesión exitoso, navegar a la siguiente pantalla (por ejemplo)
                    Toast.makeText(getActivity(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
                    // Puedes añadir la navegación a la actividad principal aquí
                } else {
                    Toast.makeText(getActivity(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtRegister.setOnClickListener(v -> {
            ((authapp.AuthActivity) requireActivity()).loadFragment(new authapp.RegisterFragment());
        });

        txtForgotPassword.setOnClickListener(v -> {
            ((authapp.AuthActivity) requireActivity()).loadFragment(new authapp.ForgotPasswordFragment());
        });

        return view;
    }
}
