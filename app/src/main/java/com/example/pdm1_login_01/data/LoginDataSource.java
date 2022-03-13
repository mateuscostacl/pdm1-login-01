package com.example.pdm1_login_01.data;

import com.example.pdm1_login_01.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public static final String username = "Mateus";
    public static final String usermail = "mateus@mateus.com";
    public static final String password = "123456";

    public Result<LoggedInUser> login(String username, String password) {

        try {
            if (verificaUsuario(username, password)) {
                LoggedInUser fakeUser = new LoggedInUser(
                        java.util.UUID.randomUUID().toString(),
                        username);
                return new Result.Success<>(fakeUser);
            }
            return new Result.Error(new IOException("Error logging in"));
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }

    private Boolean verificaUsuario(String username, String password) {
        if (username.equalsIgnoreCase(LoginDataSource.username)
                || username.equalsIgnoreCase(LoginDataSource.usermail))
            if (password.equals(LoginDataSource.password)) {
                return true;
            }
        return false;
    }
}