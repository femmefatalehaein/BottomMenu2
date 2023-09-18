package kr.ac.duksung.bottommenu2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Retrofit_interface {

    @GET("/menu/{id}")
    Call<Model> test_api_get(
            @Path("id")String itemid);
    @GET("/menu")
    Call<List<Item>> getItems();
}