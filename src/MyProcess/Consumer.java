package MyProcess;

public class Consumer extends Process {


    public Consumer(String name, int needTime, int arriveTime, TimeTurn timeTurn) {
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

    @Override
    public void run() {
//        System.out.println(timeTurn.getTime()+"秒 "+ name+ "执行，进程调度");
        if (timeTurn.product <= 0 && ranTime == 0) {
//            System.out.println(timeTurn.getTime()+"秒 "+ name+ "阻塞，产品不足");
//            System.out.println(timeTurn.product)
            timeTurn.pr.updateView(timeTurn.getTime()+"秒", name ,"阻塞，产品不足");
            timeTurn.pm.updateState(name,"block",timeTurn.pnum);
            timeTurn.block(this);

        } else {
            if(ranTime == 0){
                timeTurn.pm.setStartTime(name,timeTurn.getTime(),timeTurn.pnum);
                timeTurn.product--;
                timeTurn.pm.updateProduct(timeTurn.product);
            }
            timeTurn.run(this);

        }
        if (needTime == ranTime) {
            timeTurn.endList.add(this);
        }
    }

}
