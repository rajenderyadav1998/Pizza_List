package in.devco.pizzalist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import in.devco.pizzalist.R;
import in.devco.pizzalist.model.Item;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {
    private Context context;
    private List<Item> items;

    public PizzaAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_pizza, viewGroup, false);
        return new PizzaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder pizzaViewHolder, int i) {
        Item item = items.get(i);
        pizzaViewHolder.name.setText(item.getName());
        pizzaViewHolder.description.setText(item.getDescription());
        pizzaViewHolder.cost.setText("Rs. " + item.getCost());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PizzaViewHolder extends RecyclerView.ViewHolder {
        TextView name, description, cost;

        PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.pizza_view_name);
            description = itemView.findViewById(R.id.pizza_view_description);
            cost = itemView.findViewById(R.id.pizza_view_cost);
        }
    }
}
