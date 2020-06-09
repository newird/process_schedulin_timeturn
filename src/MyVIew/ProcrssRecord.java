package MyVIew;

import javax.swing.*;
import java.awt.*;

public class ProcrssRecord{
    JTable pm;
    JFrame frame;
    Object[][] content = new Object[100][3];
    int i = 0;

    public void createView() {
        frame = new JFrame("调度记录");
//        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        frame.setBounds(100,100,500,500);


        String[] title = {"调度时间", "调度内容", "调度原因"};
        pm = new JTable(content, title);
        contentPane.add(new JScrollPane(pm));

        frame.setVisible(true);
    }

    public void updateView(String time,String schedule,String reason) {
        pm.setValueAt(time,i,0);
        pm.setValueAt(schedule,i,1);
        pm.setValueAt(reason,i,2);
        i ++;
    }


    public static void main(String[] args) {
        ProcrssRecord p = new ProcrssRecord();
        p.createView();

    }

}
