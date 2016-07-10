package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App {

  public static void main(String[] args) {

    String dirver = "com.mysql.jdbc.Driver";
    String sql = "select distinct name from org";
    String connectionString = "jdbc:mysql://localhost/world?useSSL=false";
    String user = "root";
    String password = "123456";

    Connection conn = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
      Class.forName(dirver);
      conn = DriverManager.getConnection(connectionString, user, password);
      statement = conn.createStatement();
      resultSet = statement.executeQuery(sql);

      while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
      }

      System.out.println("\r\n use PreparedStatement");

      String sql1 = "select name from org where id = ? ";
      preparedStatement = conn.prepareStatement(sql1);
      preparedStatement.setInt(1, 2);

      resultSet.close();

      resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {

      try {
        conn.close();
      } catch (Exception e) {}

      try {
        statement.close();
      } catch (Exception e) {}

      try {
        resultSet.close();
      } catch (Exception e) {}
    }

    System.out.println("\r\n*** End ***");
  }

}
