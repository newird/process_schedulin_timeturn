package MyProcess;



public class Main {
    public static void main(String[] args) {
        TimeTurn timeTurn = new TimeTurn();
        timeTurn.init();
        Process p1 = new Producer("p1", 5, 1, timeTurn);
        Process p2 = new Consumer("c1", 5, 2, timeTurn);
        Process p4 = new Consumer("c2", 5, 3, timeTurn);
        Process p3 = new Producer("p2", 5, 4, timeTurn);
        timeTurn.add(p1);
        timeTurn.add(p2);
        timeTurn.add(p3);
        timeTurn.add(p4);
        timeTurn.turn();
    }
}
