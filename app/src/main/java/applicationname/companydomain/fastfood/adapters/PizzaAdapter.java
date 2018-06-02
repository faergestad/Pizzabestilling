package applicationname.companydomain.fastfood.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import applicationname.companydomain.fastfood.models.Pizza;
import applicationname.companydomain.fastfood.R;


public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {

    private Context context;
    private List<Pizza> list;
    private int amount = 1;
    private int total;
    private String txtPris;

    public PizzaAdapter(Context context, List<Pizza> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pizza_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Pizza pizza = list.get(position);

        final String prisStor = String.valueOf(pizza.getPrisStor());
        final String prisLiten = String.valueOf(pizza.getPrisLiten());


        holder.navn.setText(pizza.getNavn());
        holder.beskrivelse.setText(pizza.getIngredienser());
        holder.pris.setText(prisStor);

        txtPris = String.valueOf(pizza.getPrisStor());

        holder.storrelse.setText("Stor");

        holder.storrelse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String size = (String) holder.storrelse.getText();

                if (size.equals("Stor")) {
                    holder.storrelse.setText("Liten");
                    holder.pris.setText(prisLiten);
                    size = "Liten";
                } else {
                    holder.storrelse.setText("Stor");
                    holder.pris.setText(prisStor);
                    size = "Stor";
                }
            }
        });

        holder.leggTil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.leggTil.setBackgroundResource(R.drawable.cartadded);

                Snackbar snackbar = Snackbar
                        .make(v,"Lagt til i handlekurven", Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });

        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount++;
                total = Integer.parseInt(txtPris);

                int sum = total * amount;

                Log.d("sum", "" + sum);

                holder.amount.setText(String.valueOf(amount));
                holder.pris.setText(String.valueOf(sum));

            }
        });
        // TODO fiks pris opp og ned
        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount > 1) {
                    amount--;
                    total = total  * amount;

                    holder.amount.setText(String.valueOf(amount));
                    holder.pris.setText(String.valueOf(total));
                }
            }
        });

        holder.leggTil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Vil du legge til dette i handlekurven?");
                builder.setMessage(String.valueOf(amount) + " " + holder.storrelse.getText().toString().toLowerCase()
                                +" "+ pizza.getNavn() + "\nTotal: " + txtPris + ",-");

                builder.setPositiveButton("Legg til", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Legg til pizza i "Room"-db
                    }
                });
                builder.setNegativeButton("Avbryt", null);
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView navn, beskrivelse, pris, amount;
        Button storrelse, leggTil, increment, decrement;

        ViewHolder(View itemView) {
            super(itemView);

            navn = itemView.findViewById(R.id.navn);
            beskrivelse = itemView.findViewById(R.id.beskrivelse);
            pris = itemView.findViewById(R.id.pris);
            storrelse = itemView.findViewById(R.id.størrelse);
            leggTil = itemView.findViewById(R.id.addToCart);
            increment = itemView.findViewById(R.id.increment);
            decrement = itemView.findViewById(R.id.decrement);
            amount = itemView.findViewById(R.id.amount);


        }
    }

}