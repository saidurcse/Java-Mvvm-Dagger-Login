package saidur.demo.app.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import saidur.demo.app.view.login.model.LoginRequest;
import saidur.demo.app.view.signup.model.SignupRequest;

@Dao
public interface SignupDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void AddUser(SignupRequest leads);

    @Query("Select * from Signup where email = :email and password = :password")
    public LoginRequest GetUser(String email, String password);
}
