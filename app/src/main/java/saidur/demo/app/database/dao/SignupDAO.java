package saidur.demo.app.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import saidur.demo.app.view.signup.model.SignupRequest;

@Dao
public interface SignupDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public long AddUser(SignupRequest leads);
}
