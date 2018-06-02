package applicationname.companydomain.fastfood.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import applicationname.companydomain.fastfood.models.Pizza;
import applicationname.companydomain.fastfood.R;

public class HandlekurvFragment extends Fragment {

    List<Pizza> pizzas = new ArrayList<>();

    public HandlekurvFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pizzas.add(new Pizza(1, "Breskelia", "Masse kjøtt, tror jeg", 145, 185));


        Log.d("handlekurv", String.valueOf(pizzas.get(0).getNavn()));
        Log.d("handlekurv", String.valueOf(pizzas.get(0).getIngredienser()));
        Log.d("handlekurv", String.valueOf(pizzas.get(0).getPrisStor()));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_handlekurv, container, false);

    }

}
