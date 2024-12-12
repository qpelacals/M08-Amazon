package authapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

import com.example.m08_amazon.Home;
import com.example.m08_amazon.R;

import authapp.ForgotPasswordFragment;
import authapp.RegisterFragment;

public class LoginFragment extends Fragment {

    public LoginFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        EditText editEmail = root.findViewById(R.id.edit_email);
        EditText editPassword = root.findViewById(R.id.edit_password);
        Button btnLogin = root.findViewById(R.id.btn_login);
        TextView txtRegister = root.findViewById(R.id.txt_register);
        TextView txtForgotPassword = root.findViewById(R.id.txt_forgot_password);

        btnLogin.setOnClickListener(v -> {
            String email = editEmail.getText().toString();
            String password = editPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(getActivity(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí puedes reemplazarlo por una validación con una API o base de datos
                if (email.equals("user@example.com") && password.equals("password123")) {
                    // Iniciar sesión
                    Toast.makeText(getActivity(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    // Navegar a HomeActivity
                    Intent intent = new Intent(getActivity(), Home.class);
                    startActivity(intent);
                    requireActivity().finish(); // Finalizar AuthActivity
                } else {
                    Toast.makeText(getActivity(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txtRegister.setOnClickListener(v -> {
            ((authapp.AuthActivity) requireActivity()).loadFragment(new RegisterFragment());
        });

        txtForgotPassword.setOnClickListener(v -> {
            ((authapp.AuthActivity) requireActivity()).loadFragment(new ForgotPasswordFragment());
        });

        return root;
    }
}
