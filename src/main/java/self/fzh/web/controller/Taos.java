package self.fzh.web.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Taos {

    private static List<String> locationList = Arrays.asList("北京","上海","广州","深圳","天津");



    public static void main(String[] args) throws SQLException {
        String jdbcUrl = "jdbc:TAOS-RS://59.110.229.243:6041?user=root&password=taosdata";
        Connection conn = DriverManager.getConnection(jdbcUrl);
        System.out.println("Connected");
        Statement stmt = conn.createStatement();
        int i = 1;
        Random random = new Random();
        String statement = "CREATE TABLE pressure_test.%s USING pressure_test.iot_device (location, device_id) TAGS ('%s', %s)";
        while(i <= 10000){
            String tableName = "iot_device_" + i;
            int x = random.nextInt(5);
            stmt.executeUpdate(String.format(statement, tableName, locationList.get(x), i));
            i++;
        }
        conn.close();
    }
}
