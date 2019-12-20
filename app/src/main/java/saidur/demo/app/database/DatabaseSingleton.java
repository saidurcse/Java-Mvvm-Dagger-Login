package saidur.demo.app.database;

import android.content.Context;
import androidx.room.Room;

public class DatabaseSingleton {
    private static MyAppDataBase myAppDataBase;

    public static MyAppDataBase GetDatabase(Context context) {
        if (myAppDataBase == null)
            myAppDataBase = Room.databaseBuilder(context, MyAppDataBase.class, "DemoApp")
                    .allowMainThreadQueries()
                    .build();

        return myAppDataBase;
    }
}
