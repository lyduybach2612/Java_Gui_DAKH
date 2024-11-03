package GKH;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class XLKH implements IKhachHang{

    Connection cn;

    @Override
    public Connection getCon() {

        String connectionString = "jdbc:sqlserver://LAPTOP-RT1ETNCP\\LYDUYBACH;" +
                "database=DLKH;" +
                "username=sa;" +
                "password=bach2612;" +
                "encrypt=true;" +
                "trustServerCertificate=true";

        try{

            cn = DriverManager.getConnection(connectionString);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return cn;
    }

    public List<KhachHang> getAllKH(){

        List<KhachHang> khachHangs = new ArrayList<>();
        String query = "SELECT * FROM tbKH";
        try{

            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){

                KhachHang khachHang = new KhachHang();
                khachHang.setSoTK(rs.getString(1));
                khachHang.setHoTen(rs.getString(2));
                khachHang.setGt(rs.getString(3));
                khachHang.setDiaChi(rs.getString(4));
                khachHang.setSoDu(rs.getDouble(5));
                khachHangs.add(khachHang);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return khachHangs;

    }

    @Override
    public List<KhachHang> getBySoTK(String soTk) {

        List<KhachHang> khachHangs = new ArrayList<KhachHang>();
        String query = "SELECT * FROM tbKH WHERE soTk=?";
        cn = getCon();
        try{

            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, soTk);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){

                KhachHang kh = new KhachHang();
                kh.setSoTK(rs.getString(1));
                kh.setHoTen(rs.getString(2));
                kh.setGt(rs.getString(3));
                kh.setDiaChi(rs.getString(4));
                kh.setSoDu(rs.getDouble(5));
                khachHangs.add(kh);

            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return khachHangs;

    }

    @Override
    public void updateKH(KhachHang khachHang) {

        String query = "UPDATE tbKH " +
                "SET soTK=?, " +
                "hoTen=?, " +
                "gt=?, " +
                "diaChi=?, " +
                "soDu=? " +
                "WHERE soTk=?";

        cn = getCon();
        try{

            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, khachHang.getSoTK());
            ps.setString(2, khachHang.getHoTen());
            ps.setString(3, khachHang.getGt());
            ps.setString(4, khachHang.getDiaChi());
            ps.setDouble(5, khachHang.getSoDu());
            ps.executeUpdate();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
