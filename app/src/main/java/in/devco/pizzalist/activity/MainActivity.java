package in.devco.pizzalist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import in.devco.pizzalist.R;
import in.devco.pizzalist.adapter.PizzaAdapter;
import in.devco.pizzalist.model.Item;
import in.devco.pizzalist.presenter.DataPresenter;
import in.devco.pizzalist.view.DataView;

public class MainActivity extends AppCompatActivity implements DataView, View.OnClickListener {
    private DataPresenter dataPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.main_activity_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dataPresenter = new DataPresenter(this);
        dataPresenter.fetchData();
    }

    @Override
    public void loadData(List<Item> items) {
        recyclerView.setAdapter(new PizzaAdapter(this, items));
    }

    @Override
    public void loadFailed() {
        Snackbar.make(findViewById(R.id.main_activity_content), "No Internet", Snackbar.LENGTH_INDEFINITE)
                .setAction("Try Again", this)
                .show();
    }

    @Override
    public void onClick(View view) {
        dataPresenter.fetchData();
    }
}
