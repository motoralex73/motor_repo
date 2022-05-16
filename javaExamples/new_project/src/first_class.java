import java.net.*;

public class first_class {


    public static int serverPort = 666;
    public static int clientPort = 999;
    public static int buffer_size = 1024;
    public static DatagramSocket ds;
    public static byte buffer[] = new byte[buffer_size];

    public static void TheServer() throws Exception {
        int pos = 0;
        while (true) {
            int c = System.in.read();
            switch(c) {
                case -1:
                System.out.println("Server Quits.");
                return;
                case '\r':
                    ds.send(new DatagramPacket(buffer,pos,InetAddress.getLocalHost(),clientPort));
                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }

    public void func()
    {
        System.out.println("Hello");
    }

    public void TheClient() throws Exception {
        while (true) {
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            ds.receive(p);
            System.out.println(new String(p.getData(),0,p.getLength()));
        }
    }

    public static class public_main {

        public void main(String args[]) throws Exception {
//        if (args.length == 1) {
//                ds = new DatagramSocket(serverPort);
//                TheServer();
//            }
//            else {
//                ds = new DatagramSocket(clientPort);
//                TheClient();
//            }

//            first_class fs[] = new first_class[5];
//            for (int i=0;i<fs.length;i++) fs[i] = new first_class();
//            fs[0].func();
        }
    }



}



