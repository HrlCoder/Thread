package Homework;

public class SequencePrint {

    public static void main(String[] args) {
        Thread c = new Thread(new Task("C",null));
        Thread b = new Thread(new Task("B",c));
        Thread a = new Thread(new Task("A",b));
        c.start();
        b.start();
        a.start();
    }

    public static class Task implements Runnable {

        private String Zimu;
        private Thread joinZimu;

        public Task(String zimu, Thread joinZimu) {
            Zimu = zimu;
            this.joinZimu = joinZimu;
        }

        @Override
        public void run() {
            try {
                if(joinZimu != null) {
                    joinZimu.join();
                }
                System.out.println(Zimu);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



//    public static void main(String[] args) {
//        Thread c = new Thread(new PrintTask("C",null));
//        Thread b = new Thread(new PrintTask("B",c));
//        Thread a = new Thread(new PrintTask("A",b));
//        a.start();
//        b.start();
//        c.start();
//    }
//
//    public static class PrintTask implements Runnable {
//
//        private String content;
//        private Thread jointask;
//
//        public PrintTask(String content,Thread jointask) {
//            this.content = content;
//            this.jointask = jointask;
//        }
//
//        @Override
//        public void run() {
//            try {
//                if(jointask != null)
//                    jointask.join();
//                System.out.println(content);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
