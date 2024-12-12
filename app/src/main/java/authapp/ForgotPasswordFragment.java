package authapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.example.m08_amazon.R;

public class ForgotPasswordFragment extends Fragment {

    public ForgotPasswordFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);

        EditText editEmail = view.findViewById(R.id.edit_email);
        Button btnResetPassword = view.findViewById(R.id.btn_reset_password);

        btnResetPassword.setOnClickListener(v -> {
            String email = editEmail.getText().toString();

            // Lógica de recuperación de contraseña
            if (email.isEmpty()) {
                Toast.makeText(getActivity(), "Por favor, ingrese un correo electrónico", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí puedes enviar un enlace para restablecer la contraseña (esto es solo un ejemplo)
                Toast.makeText(getActivity(), "Se ha enviado un enlace para restablecer la contraseña a: " + email, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
