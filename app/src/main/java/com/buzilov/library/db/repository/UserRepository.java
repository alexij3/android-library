package com.buzilov.library.db.repository;

import com.activeandroid.query.Select;
import com.buzilov.library.model.User;

public class UserRepository {

    public Long create(User user) {
        return user.save();
    }

    public User getByEmailAndPassword(String email, String password) {
        return new Select()
                .from(User.class)
                .where("email = ?", email)
                .and("password = ?", password)
                .executeSingle();
    }
}
