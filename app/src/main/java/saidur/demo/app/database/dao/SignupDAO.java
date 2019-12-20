package saidur.demo.app.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import saidur.demo.app.view.signup.model.SignupRequest;

@Dao
public interface SignupDAO {
    @Insert
    public long AddUser(SignupRequest leads);
}
