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

public class RegisterFragment extends Fragment {

    public RegisterFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        EditText editName = view.findViewById(R.id.edit_name);
        EditText editEmail = view.findViewById(R.id.edit_email);
        Button btnRegister = view.findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String email = editEmail.getText().toString();

            // Lógica de registro
            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(getActivity(), "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                // Aquí podrías realizar un proceso de validación o guardar los datos del usuario en una base de datos
                Toast.makeText(getActivity(), "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
                // Regresar al login o navegar a la siguiente pantalla
            }
        });

        return view;
    }
}
