package applicationname.companydomain.fastfood.dbModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "handlekurv")
public class Handlekurv {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "pizzaID")
    private int id;

    @ColumnInfo(name = "pizzaNavn")
    private String name;

    @ColumnInfo(name = "pizzaPris")
    private int price;

    @Ignore
    public Handlekurv(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Handlekurv{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
