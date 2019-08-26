package in.devco.pizzalist.presenter;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Objects;

import in.devco.pizzalist.API;
import in.devco.pizzalist.Const;
import in.devco.pizzalist.model.Menu;
import in.devco.pizzalist.view.DataView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class DataPresenter implements Callback<Menu> {
    private DataView dataView;

    public DataPresenter(DataView dataView) {
        this.dataView = dataView;
    }

    public void fetchData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        API apiParser = retrofit.create(API.class);
        Call<Menu> call = apiParser.getItems();
        call.enqueue(this);
    }

    @Override
    public void onResponse(@NonNull Call<Menu> call, Response<Menu> response) {
        if (!response.isSuccessful() || response.body() == null)
            Log.e("retrofit", "Code: " + response.code());
        else{
            Menu items = response.body();
            dataView.loadData(items.getItems());
        }
    }

    @Override
    public void onFailure(@NonNull Call<Menu> call, Throwable t) {
        dataView.loadFailed();
        Log.e("retrofit", Objects.requireNonNull(t.getMessage()));
    }
}
