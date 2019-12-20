package saidur.demo.app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import saidur.demo.app.database.dao.SignupDAO;
import saidur.demo.app.view.signup.model.SignupRequest;

@Database(entities = {SignupRequest.class} , version = 1, exportSchema = false)
public abstract class MyAppDataBase extends RoomDatabase {
    public abstract SignupDAO leadsDAO();
}

