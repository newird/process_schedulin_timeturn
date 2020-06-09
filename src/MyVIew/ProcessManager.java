package MyVIew;

import MyProcess.Process;
import MyProcess.Producer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.Queue;

public class ProcessManager {
    JFrame frame = new JFrame("调度管理");
    Object[][] content = new Object[25][5];
    Object[][] content2 = new Object[25][2];
    Object[][] content3 = new Object[25][2];
    JTable procesState;
    JTable variable;
    JTable list;
    int i = 0;
    JTextField timeField;

    public void creatView() {
        frame.setBounds(500, 100, 900, 500);
        JPanel left = new JPanel();
        left.setLayout(null);


        JButton b1 = new JButton("创建生产者进程");
        JButton b2 = new JButton("创建消费者进程");
        b1.setBounds(20, 10, 120, 20);
        b2.setBounds(150, 10, 120, 20);
        left.add(b1);
        left.add(b2);


        JTextField name = new JTextField();
        name.setBounds(20, 40, 40, 20);
        JTextField arriveTime = new JTextField();
        arriveTime.setBounds(70, 40, 30, 20);
        JTextField needTime = new JTextField();
        needTime.setBounds(110, 40, 30, 20);
        JButton run = new JButton("运行");
        run.setBounds(150, 40, 80, 20);
        left.add(name);
        left.add(arriveTime);
        left.add(needTime);
        left.add(run);

        String[] title = {"进程名", "到达时间", "进程状态", "剩余时间","开始时间"};
        DefaultTableModel stateModel = new DefaultTableModel(content, title);
        procesState = new JTable(stateModel);
        JScrollPane scroll = new JScrollPane(procesState);
        scroll.setBounds(20, 80, 300, 300);
        left.add(scroll);

        timeField = new JTextField("1秒");
        timeField.setBounds(380, 10, 50, 20);
        left.add(timeField);

        JLabel CPU = new JLabel("CPU调度记录");
        CPU.setBounds(380, 40, 100, 20);
        left.add(CPU);

        String[] title2 = {"变量名", "值"};
        content2[0][0] = "产品";
        content2[0][1] = 0;
        variable = new JTable(content2, title2);
        JScrollPane scroll1 = new JScrollPane(variable);
        scroll1.setBounds(380, 80, 200, 300);
        left.add(scroll1);


        String[] title3 = {"就绪队列", "等待队列"};
        list = new JTable(content3, title3);
        JScrollPane scroll2 = new JScrollPane(list);
        scroll2.setBounds(600, 80, 200, 300);
        left.add(scroll2);

        frame.add(left);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void addProcess(String name ,int arriveTime,String state,int leftTime,int startTime){
        procesState.setValueAt(name,i,0);
        procesState.setValueAt(arriveTime,i,1);
        procesState.setValueAt(state,i,2);
        procesState.setValueAt(leftTime,i,3);
        procesState.setValueAt(startTime,i,4);
        i++;
    }
    public void updateLeftTime(String name,int left){
        for(int i = 0 ;i< 4;i++){
            if(procesState.getValueAt(i,0).equals(name)){
                procesState.setValueAt(left,i,3);
            }
        }
    }
    public void updateState(String name,String state){
        for(int i =0 ;i< 4;i++){
            if(procesState.getValueAt(i,0).equals(name)){
                procesState.setValueAt(state,i,2);
            }
//            System.out.println(procesState.getValueAt(i,0));
        }
    }
    public void setStartTime(String name,int time){
        for(int i =0 ;i< 4;i++){
            if(procesState.getValueAt(i,0).equals(name)){
                procesState.setValueAt(time,i,4);
            }
        }
    }


    public void updateProduct(int product) {
        variable.setValueAt(product, 0, 1);
    }

    public void updateReady(Queue<Process> processes) {
        int j = 0;
        for (Process process : processes) {
            list.setValueAt(process.getName(), j, 0);
            j++;
        }
        j--;
        while (j++ < 15) {
            list.setValueAt("", j, 0);
        }
    }


    public void updateBlock(Queue<Process> processes) {
        int j = 0;
        for (Process process : processes) {
            list.setValueAt(process.getName(), j, 1);
            j++;
        }
        while (j < 15) {
            list.setValueAt("", j, 1);
            j++;
        }
    }

    public void updateTime(int time) {
        timeField.setText(time + "秒");
    }

    public static void main(String[] args) {
        ProcessManager pm = new ProcessManager();
        pm.creatView();
    }
}
