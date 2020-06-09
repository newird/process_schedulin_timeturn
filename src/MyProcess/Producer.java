package MyProcess;

public class Producer extends Process {

    public Producer(String name, int needTime, int arriveTime, TimeTurn timeTurn) {
        super(name, needTime, arriveTime, timeTurn);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getNeedTime() {
        return super.getNeedTime();
    }

    @Override
    public void setNeedTime(int needTime) {
        super.setNeedTime(needTime);
    }

    @Override
    public int getArriveTime() {
        return super.getArriveTime();
    }

    @Override
    public void setArriveTime(int arriveTime) {
        super.setArriveTime(arriveTime);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void run() {
        if(ranTime == 0){
            timeTurn.pm.setStartTime(name,timeTurn.getTime(),timeTurn.pnum);
        }
        timeTurn.run(this);
        if (needTime == ranTime) {
            timeTurn.product++;
            timeTurn.pm.updateProduct(timeTurn.product);
            timeTurn.readyList.remove(this);
            timeTurn.endList.add(this);
        }
    }

}
