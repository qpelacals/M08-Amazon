package authapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.fragment.app.Fragment;

import com.example.m08_amazon.Home;
import com.example.m08_amazon.R;

public class RegisterFragment extends Fragment {

    public RegisterFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_register, container, false);

        EditText editName = root.findViewById(R.id.edit_name);
        EditText editEmail = root.findViewById(R.id.edit_email);
        EditText editPassword = root.findViewById(R.id.edit_password);
        EditText editConfirmPassword = root.findViewById(R.id.edit_confirm_password);
        Button btnRegister = root.findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String password = editPassword.getText().toString();
            String confirmPassword = editConfirmPassword.getText().toString();

            // Validar que todos los campos estén completos
            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Toast.makeText(getActivity(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validar formato de email
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(getActivity(), "Por favor, ingresa un email válido", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validar que las contraseñas coincidan
            if (!password.equals(confirmPassword)) {
                Toast.makeText(getActivity(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                return;
            }

            // Validar la longitud de la contraseña (mínimo 6 caracteres)
            if (password.length() < 6) {
                Toast.makeText(getActivity(), "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(getActivity(), "Registro exitoso", Toast.LENGTH_SHORT).show();

            // Navegar a HomeActivity
            Intent intent = new Intent(getActivity(), Home.class);
            startActivity(intent);
            requireActivity().finish(); // Finalizar AuthActivity
        });

        return root;
    }
}
