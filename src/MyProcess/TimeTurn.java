package MyProcess;


import MyVIew.ProcessManager;
import MyVIew.ProcrssRecord;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TimeTurn {
    private int TimeTurn = 3;
    private int time = 1;
    Queue<Process> createList = new LinkedList<>();
    Queue<Process> readyList = new LinkedList<>();
    Queue<Process> blockList = new LinkedList<>();
    Queue<Process> endList = new LinkedList<>();
    int product = 0;
    ProcrssRecord pr = new ProcrssRecord();
    ProcessManager pm = new ProcessManager();

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void add(Process p) {
        createList.add(p);
//        pm.addProcess("1",1,"a",2);
        pm.addProcess(p.getName(), p.arriveTime, "ready", (p.needTime - p.ranTime),0);
    }

    public void ready() {
        Iterator<Process> it = createList.iterator();
        while (it.hasNext()) {
            Process p = it.next();
            if (p.arriveTime <= time) {
                it.remove();
                readyList.offer(p);

//                System.out.println(time + "秒 " + p.name + "就绪，进程到达");
                pr.updateView(time + "秒", p.name, "就绪，进程到达");
            }

        }
    }

    public void run(Process p) {
        for (int i = 0; i < TimeTurn; i++) {
//            System.out.println(time+"秒 " + p.name + " 执行");
//            System.out.println(p.needTime);
            time++;
            pm.updateTime(time);
            pm.updateLeftTime(p.name, (p.needTime - p.ranTime - 1));
            if (!createList.isEmpty()) {
                ready();
            }

            p.ranTime++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            pm.updateReady(readyList);
            pm.updateBlock(blockList);

            if (p.needTime - p.ranTime <= 0) {
                break;
            }
        }

        if (p.needTime > p.ranTime) {
            readyList.offer(p);
            pm.updateReady(readyList);
//            System.out.println(time + "秒 " + p.name + "就绪，时间片到");
            pr.updateView(time + "秒", p.name, "就绪，时间片到");
            pm.updateState(p.name,"ready");
        } else {
//            System.out.println(time + "秒 " + p.name + "结束,运行完成");
            pr.updateView(time + "秒", p.name, "结束,运行完成");
            pm.updateState(p.name,"finished");
        }

    }

    public void init() {
        pr.createView();
        pm.creatView();
    }

    public void turn() {
        while (true) {
            if (!createList.isEmpty()) {
                ready();
            }
            if (!readyList.isEmpty()) {
                Process p = readyList.poll();
//                System.out.println(time + "秒 " + p.name + "执行，进程调度");
                pr.updateView(time + "秒", p.name, "执行，进程调度");
                pm.updateState(p.name,"run");
                p.run();
                while (product > 0 && !blockList.isEmpty()) {
                    Process q = blockList.poll();
                    readyList.offer(q);
                }
            } else {
                break;
            }
        }
    }

    public void block(Process p) {
        blockList.add(p);

    }

    @Override
    public String toString() {
        return "TimeTurn{" +
                "TimeTurn=" + TimeTurn +
                ", readyList=" + readyList +
                ", blockList=" + blockList +
                ", product=" + product +
                '}';
    }
}
