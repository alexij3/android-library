package com.buzilov.library.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.buzilov.library.db.table.Users;

@Table(name = Users.TABLE_NAME)
public class User extends Model {

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String displayName;

    public User() {
        super();
    }

}
