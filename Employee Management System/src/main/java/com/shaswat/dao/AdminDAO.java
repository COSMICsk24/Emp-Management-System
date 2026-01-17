package com.shaswat.dao;

import com.shaswat.beans.Admin;

import java.sql.SQLException;

public interface AdminDAO {
    public boolean validate(Admin admin) throws SQLException, ClassNotFoundException;
}
