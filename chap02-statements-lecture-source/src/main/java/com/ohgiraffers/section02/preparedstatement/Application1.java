package com.ohgiraffers.section02.preparedstatement;

//import com.sun.jdi.connect.spi.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {
    public static void main(String[] args) {

        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            // statement 와 달리 prepareStatement 는 생성 당시에 쿼리가 있어야 한다
            pstmt = con.prepareStatement("SELECT  EMP_ID, EMP_NAME FROM EMPLOYEE");

            rset = pstmt.executeQuery();

            while (rset.next()) {
                System.out.println(rset.getString("EMP_ID")
                + ", " + rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 후입선출이라 생각하면 됨
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}
