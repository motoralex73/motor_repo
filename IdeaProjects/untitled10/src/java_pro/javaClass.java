package java_pro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class javaClass {
    public static void main(String[] args) {
        System.out.println("main java");
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<100;i++) list.add(i);
        list.remove(5);
        System.out.println(list);
        System.out.println(list.get(10));
        System.out.println(list.size());
        list = new LinkedList<>();

        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        MyThread myThread2 = new MyThread();
        myThread2.start();

        System.out.println("Hello my main thread");

        myThread.show();


    }
}

class MyThread extends Thread implements MyInterface{
    public void run() {
        for(int i=0;i<100;i++) System.out.println("Hello my thread "+i+" thread id = "+Thread.currentThread().getName());
    }

    @Override
    public void show() {
        System.out.println("show hello");
    }
}

interface MyInterface {
    public void show();
}