package applicationname.companydomain.fastfood.local;

import android.arch.persistence.room.Database;

import applicationname.companydomain.fastfood.dbModel.Handlekurv;

import static applicationname.companydomain.fastfood.local.HandlekurvDatabase.DATABASE_VERSION;

@Database(entities = Handlekurv.class, version = DATABASE_VERSION)
public abstract class HandlekurvDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "EDMT-Database-Room";

    public abstract UserDAO userDAO;

    private static HandlekurvDatabase mInstance;

}
