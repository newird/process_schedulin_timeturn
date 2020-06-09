package MyProcess;

public class Process {
    String name;
    int needTime;
    int arriveTime;
    TimeTurn timeTurn;
    int ranTime;
    public Process(String name, int needTime, int arriveTime, TimeTurn timeTurn) {
        this.name = name;
        this.needTime = needTime;
        this.arriveTime = arriveTime;
        this.timeTurn = timeTurn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNeedTime() {
        return needTime;
    }

    public void setNeedTime(int needTime) {
        this.needTime = needTime;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public void run() {
    }

    @Override
    public String toString() {
        return "Process{" +
                "name='" + name + '\'' +
                ", needTime=" + needTime +
                ", arriveTime=" + arriveTime +
                ", timeTurn=" + timeTurn +
                '}';
    }
}
