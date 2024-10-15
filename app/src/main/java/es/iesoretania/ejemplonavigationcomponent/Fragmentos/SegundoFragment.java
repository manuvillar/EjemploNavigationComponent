package es.iesoretania.ejemplonavigationcomponent.Fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.iesoretania.ejemplonavigationcomponent.R;
import es.iesoretania.ejemplonavigationcomponent.databinding.FragmentInicioBinding;
import es.iesoretania.ejemplonavigationcomponent.databinding.FragmentSegundoBinding;

public class SegundoFragment extends Fragment {
    private FragmentSegundoBinding binding;

    public SegundoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSegundoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(view);

        //Obtenemos los argumentos si no son nulos.
        if (getArguments()!= null){
            //Los guardamos vía Bundle.
            SegundoFragmentArgs args = SegundoFragmentArgs.fromBundle(getArguments());
            //Los sacamos de este Bundle.
            String texto = args.getTexto();
            int numero = args.getNumero();

            binding.TextViewTexto.setText("El texto es:"+ texto);
            binding.TextViewNumero.setText("El número es: "+ numero);
        }

        binding.botonContinuarSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_segundoFragment_to_finalFragment);
            }
        });

        binding.botonCancelarSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_segundoFragment_to_inicioFragment);
            }
        });
    }
}