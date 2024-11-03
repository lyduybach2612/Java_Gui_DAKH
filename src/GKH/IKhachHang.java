package GKH;

import java.sql.Connection;
import java.util.List;

public interface IKhachHang {

    Connection getCon();
    List<KhachHang> getBySoTK(String soTk);
    void updateKH(KhachHang khachHang);

}
