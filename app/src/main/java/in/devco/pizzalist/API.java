package in.devco.pizzalist;

import in.devco.pizzalist.model.Menu;
import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("pizza/?format=xml")
    Call<Menu> getItems();
}
