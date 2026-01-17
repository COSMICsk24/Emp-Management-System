package com.shaswat.daoImpl;

import com.shaswat.beans.Admin;
import com.shaswat.dao.AdminDAO;
import com.shaswat.utility.JDBCConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAOImpl implements AdminDAO {
    private static final String SELECT_QUERY = "select * from admin where empId=? and password=?";
    @Override
    public boolean validate(Admin admin) throws SQLException, ClassNotFoundException {
        boolean status = false;
        //Jdbc code
        Connection con = JDBCConnectionUtility.getConnection();
        PreparedStatement ps = con.prepareStatement(SELECT_QUERY);
        ps.setInt(1,admin.getEmpId());
        ps.setString(2, admin.getPassword());
        System.out.println(ps);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt(1);
            String pass = rs.getNString(2);
            if (admin.getEmpId() == id && admin.getPassword().equals(pass)) {
                status = true;
            }
        }
        return status;
    }
}
