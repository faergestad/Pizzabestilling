package applicationname.companydomain.fastfood.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import applicationname.companydomain.fastfood.models.Pizza;
import applicationname.companydomain.fastfood.R;
import applicationname.companydomain.fastfood.adapters.PizzaAdapter;

import static java.lang.Integer.parseInt;


public class PizzaFragment extends Fragment {

    private RecyclerView mRecyclerview;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Pizza> pizzaList;
    private RecyclerView.Adapter adapter;

    public static final String JSON_URL = "http://10.0.2.2/fastfood/api.php/pizza?&transform=1";

    public PizzaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);

        mRecyclerview = view.findViewById(R.id.recycler);

        pizzaList = new ArrayList<>();
        adapter = new PizzaAdapter(getContext(), pizzaList);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mRecyclerview.getContext(), linearLayoutManager.getOrientation());

        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(linearLayoutManager);
        mRecyclerview.addItemDecoration(dividerItemDecoration);
        mRecyclerview.setAdapter(adapter);

        getData();

        return view;
    }

    private void getData() {

        StringRequest jsonStringRequest = new StringRequest(JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray jsonPizzaArray = jsonObject.optJSONArray("pizza");

                for (int i = 0; i < jsonPizzaArray.length(); i++) {
                    try {
                        JSONObject jsonPizza = (JSONObject) jsonPizzaArray.get(i);
                        Pizza pizza = new Pizza(jsonPizza);

                        pizza.setpID(parseInt(jsonPizza.getString("pID")));
                        pizza.setNavn(jsonPizza.getString("navn"));
                        pizza.setIngredienser(jsonPizza.getString("ingredienser"));
                        pizza.setPrisLiten(parseInt(jsonPizza.getString("prisLiten")));
                        pizza.setPrisStor(parseInt(jsonPizza.getString("prisStor")));

                        pizzaList.add(pizza);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonStringRequest);
    }

}
