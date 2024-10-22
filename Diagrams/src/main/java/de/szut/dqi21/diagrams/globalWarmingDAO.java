package de.szut.dqi21.diagrams;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class globalWarmingDAO {
    public static final String DB_NAME = "globalWarming.sqlite";
    public static final String URL = "jdbc:sqlite:" + DB_NAME;

    public List<YearTemp> queryAllYearTemps() {
        String sql = "SELECT * FROM globalWarming";
        List<YearTemp> yearTempList = new ArrayList<>();

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                YearTemp yearTemp = new YearTemp(rs.getInt("Year"), rs.getFloat("Temp"));
                yearTempList.add(yearTemp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(yearTempList);
        return yearTempList;
    }

    private Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
