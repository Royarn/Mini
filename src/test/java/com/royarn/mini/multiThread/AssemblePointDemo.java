package com.royarn.mini.multiThread;

/**
 * @author lizq
 * @Description: ${todo}
 * @date 2018/7/23 10:50
 */
public class AssemblePointDemo {

    static class Tourist extends Thread {

        AssemblePoint ap;
        public Tourist(AssemblePoint ap) {
            this.ap = ap;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((int) (Math.random() * 100));
                ap.await();
                System.out.println("==============" + Thread.currentThread().getName() + "===========" + " arrived");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int num = 10;
        Tourist[] tourists = new Tourist[num];
        AssemblePoint ap = new AssemblePoint(num);
        for (int i=0;i<num;i++) {
            tourists[i] = new Tourist(ap);
            tourists[i].start();
        }
    }
}