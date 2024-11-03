package GKH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUI_updateKH extends JFrame {

    private final String[] diaChis = {"Hà Nội", "Đà Nẵng", "Cần Thơ"};
    private final String[] headers = {"Số TK", "Họ tên", "Giới tính", "Địa chỉ", "Số dư"};
    private JTextField tf_soTK;
    private JTextField tf_hoTen;
    private JTextField tf_gt;
    private JTextField tf_soDu;
    private JComboBox<String> cb_diaChi;
    private JButton btn_tk;
    private JButton btn_update;
    private JLabel lb_soTK;
    private JLabel lb_hoTen;
    private JLabel lb_gt;
    private JLabel lb_soDu;
    private JLabel lb_diaChi;
    private JPanel panel;
    private DefaultTableModel model;
    private JTable table;


    public GUI_updateKH() {

        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        initializeComponents();
        this.setVisible(true);

    }

    public void initializeComponents() {

        this.tf_soTK = new JTextField();
        this.tf_hoTen = new JTextField();
        this.tf_gt = new JTextField();
        this.tf_soDu = new JTextField();
        this.cb_diaChi = new JComboBox<>(diaChis);
        this.btn_tk = new JButton("Tìm kiếm");
        this.btn_update = new JButton("Cập nhật");
        this.lb_soTK = new JLabel("Số TK");
        this.lb_hoTen = new JLabel("Họ tên");
        this.lb_gt = new JLabel("Giới tính");
        this.lb_diaChi = new JLabel("Địa chỉ");
        this.lb_soDu = new JLabel("Số dư");
        this.panel = new JPanel(new GridLayout(1,1));
        this.model = new DefaultTableModel(headers,0);
        this.table = new JTable(model);
        this.panel.add(new JScrollPane(table));

        this.lb_soTK.setBounds(10,10,80,25);
        this.lb_hoTen.setBounds(10,45,80,25);
        this.lb_gt.setBounds(10,80,80,25);
        this.lb_diaChi.setBounds(10,115,80,25);
        this.lb_soDu.setBounds(10,150,80,25);

        this.tf_soTK.setBounds(100,10, 210, 25);
        this.tf_hoTen.setBounds(100,45,210, 25);
        this.tf_gt.setBounds(100,80,210, 25);
        this.cb_diaChi.setBounds(100,115,210, 25);
        this.tf_soDu.setBounds(100,150,210, 25);

        this.btn_tk.setBounds(100,185,100,25);
        this.btn_tk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                XLKH xlkh = new XLKH();
                List<KhachHang> khachHangs = xlkh.getBySoTK(tf_soTK.getText());
                model.setRowCount(0);
                for(KhachHang kh : khachHangs) {

                    String[] row = {
                            kh.getSoTK(),
                            kh.getHoTen(),
                            kh.getGt(),
                            kh.getDiaChi(),
                            String.valueOf(kh.getSoDu())
                    };
                    model.addRow(row);

                }
            }

        });

        this.btn_update.setBounds(210,185,100,25);
        this.btn_update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                

            }

        });
        this.panel.setBounds(100,220,400,400);

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {

                XLKH xlkh = new XLKH();
                List<KhachHang> khachHangs = xlkh.getAllKH();
                for(KhachHang kh : khachHangs){

                    String[] row = {
                            kh.getSoTK(),
                            kh.getHoTen(),
                            kh.getGt(),
                            kh.getDiaChi(),
                            String.valueOf(kh.getSoDu())
                    };
                    model.addRow(row);

                }

            }

        });

        this.table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {



            }

        });

        this.add(tf_soTK);
        this.add(tf_hoTen);
        this.add(tf_gt);
        this.add(tf_soDu);
        this.add(lb_diaChi);
        this.add(lb_hoTen);
        this.add(lb_gt);
        this.add(lb_soTK);
        this.add(lb_soDu);
        this.add(cb_diaChi);
        this.add(btn_tk);
        this.add(btn_update);
        this.add(panel);

    }


}
