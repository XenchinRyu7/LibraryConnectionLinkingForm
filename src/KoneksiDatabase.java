import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KoneksiDatabase {

    private Statement st;
    private ResultSet rs;
    public Connection connect;

    public KoneksiDatabase(String database) {
        String jdbcUrl = database;
        String username = "root";
        String password = "";
        String driver = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            System.out.println("" + e.getLocalizedMessage());
        }
    }

    public String[] querySql(String query) {
        String[] k = null;  // Deklarasikan di luar blok while

        try {
            st = connect.createStatement();
            rs = st.executeQuery(query);

            // Tentukan ukuran array berdasarkan jumlah baris yang dikembalikan
            int rowCount = 0;
            if (rs.last()) {
                rowCount = rs.getRow();
                rs.beforeFirst();  // Kembalikan kursor ke posisi awal
            }

            k = new String[rowCount * 2];  // Setiap baris memiliki 2 kolom

            int index = 0;
            while (rs.next()) {
                k[index++] = rs.getString(1);
                k[index++] = rs.getString(2);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            closeConnection();
        }

        return k;
    }


    public void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
