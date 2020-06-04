package com.buzilov.library.db.repository;

import com.buzilov.library.model.User;

public class UserRepository {

    public Long create(User user) {
        return user.save();
    }

}
