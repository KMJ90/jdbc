package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application1 {

    private static String empId = "200";
    private static String empName = "선동일";

    public static void main(String[] args) {

        // Connection 은 java.sql.Connection 인터페이스로 데이터베이스 연결을 나타냄 (데이터베이스와 통신에 사용)
        Connection con = getConnection();  // getConnection() : Connection 객체를 반환하는 메소드
        Statement stmt = null;
        ResultSet rset = null;

        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND EMP_NAME = '" + empName + "'";
        System.out.println(query);

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            if (rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
                System.out.println("회원 정보가 없습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {  // 예외발생시 예외처리 실행되고 사용한 자원을 해제함 (자원 누수 관리)
            close(rset);
            close(stmt);
            close(con);
        }

    }
}
