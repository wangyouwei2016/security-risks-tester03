package com.example.demo.owasp.a03_injection;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;  

/**
 * 
 * A03:2021-Injection 
 * 是指在软件或系统中由于输入未经有效验证、处理或转义，导致恶意输入被解释和执行为代码，从而引发安全问题。
 * 风险点：SQL注入, 非配置硬编码的连接串， 未处理的结果集
 * CWE-89 Improper Neutralization of Special Elements used in an SQL Command ('SQL Injection')
 */
public class SQLInjection {
	public static void sqlInjection(String username, String password) {
        String connectionString = "jdbc:mysql://localhost:3306/mydatabase";  
        try {  
            Connection connection = DriverManager.getConnection(connectionString, username, password);  
            Statement statement = connection.createStatement();  
            String sqlQuery = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";  
            ResultSet resultSet = statement.executeQuery(sqlQuery);  
            // 处理查询结果...  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
	}

}
