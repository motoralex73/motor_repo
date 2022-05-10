package com.company;
import java.awt.*;
import java.applet.*;
import java.beans.*;

public class SimpleBanner extends Applet implements Runnable {
    String msg = "A simple moving banner.";
    Thread t = null;
    int state;
    boolean stopFlag;

}

public class Main {

    public static void main(String[] args) {
	// write your code here
        //SimpleBanner sb = new SimpleBanner();
    SimpleBeanInfo sbi = new SimpleBeanInfo();
        try {
            sbi.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
