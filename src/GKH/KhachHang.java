package GKH;

public class KhachHang {

    private String soTK;
    private String hoTen;
    private String gt;
    private String diaChi;
    private double soDu;

    public KhachHang() {
    }

    public KhachHang(String soTK, String hoTen, String gt, String diaChi, double soDu) {
        this.soTK = soTK;
        this.hoTen = hoTen;
        this.gt = gt;
        this.diaChi = diaChi;
        this.soDu = soDu;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }
}
