package applicationname.companydomain.fastfood.local;


import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import applicationname.companydomain.fastfood.dbModel.Handlekurv;
import applicationname.companydomain.fastfood.models.Pizza;
import io.reactivex.Flowable;

public interface UserDAO {

    @Query("SELECT * FROM handlekurv")
    Flowable<List<Handlekurv>> getAllFromCart();

    @Insert
    void insertPizza(Pizza... pizzas);

    @Update
    void updatePizza(Pizza... pizza);

    @Delete
    void deletePizza(Pizza pizza);

    @Query("DELETE FROM handlekurv")
    void deleteCart();

}
