package java_base;

import java.awt.event.*;
import java.io.*;
import java.awt.*;
import java.applet.Applet;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.*;
import java.util.List;
//import java.desktop.java.applet.*;


//import static jdk.internal.org.jline.utils.Colors.s;


public class StudyBaseJava extends Frame{

/*
<applet code="AppletSkel" width=300 height=100>
</applet>
*/
    public class AppletSkel extends Applet {
        public void init() {}
        public void start() {}
        public void stop() {}
        public void destroy() {}
        public void paint(Graphics g) {}
    }

    public static class MyClass {
        int hlp;
        void printHlp()
        {
            System.out.println("hlp = "+this.hlp);
        }
        void setHlp(int hlp)
        {
            this.hlp = hlp;
        }
        public MyClass(){};
        public MyClass(int hlp)
        {
          this.hlp = hlp;
        };
    }
    static class ChildMyClass extends MyClass {
        @Override
        void setHlp(int hlp) {
            super.setHlp(hlp);
        }
    }

    public static class PrintString {
        public void print_string() throws IOException
        {
            String str1;
            str1 = "fjghdfjkghdkjfghkdjfg";
            str1 = str1.toUpperCase();

            StringBuffer sb = new StringBuffer(str1.length());
            sb.append(str1);
            System.out.println(sb+" sb len="+sb.capacity());

            String str;
            char c;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter symbols, q - exit ");
//        do {
//             c = (char) br.read();
//             System.out.print(c);
//        } while (c != 'q');
            do {
                str = br.readLine();
                System.out.println(str);
            } while (!str.equals("stop"));
        }

        public void func_exception() throws  IOException
        {
            System.out.println("Start program");
            try {
                int d = 123;
                int d0 = 0;
                d = d/d0;
                System.out.println("Операция деления на ноль");
            }
            catch(ArithmeticException e) {
                System.out.println("Исключение деления на ноль");
            }
            System.out.println("Продолжение проги");

            MyClass mc = new MyClass(444);
            mc.printHlp();
        }
    }

    public static class StudyThread extends Thread implements Runnable{

        int num=0;
        //запуск потока в конструкторе
        StudyThread(String name, int num) {
            super(name);
            this.num = num;
            System.out.println("Новый поток "+name);
            setPriority(1+num);
            start(); //запуск run, можно в main запустить
        }
        //описание действий потока
        @Override
        public void run() {
            try {
               while (true)
               {
                   //if (this.num==1)
                   System.out.println("name thread "+this.getName()+" num = "+num+" date: "+ new Date());
                   Thread.sleep(500);
               }
           }
            catch (Exception e) {
                System.out.println("Exception");
            }
        }
    }

    public static class WriteToFile {

        public void funcWriteToFile() throws IOException, FileNotFoundException
        {
            int i=0;
            FileInputStream fin;
            try {
                fin = new FileInputStream("new_file.txt");
            }
            catch (FileNotFoundException e)
            {
                System.out.println("С файлом какая-то ерунда");
                return;
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                 System.out.println("Используйте имя_файла");
                 return;
            }

            do {
                i = fin.read();
                if (i != -1) System.out.print((char) i);
            } while(i!=-1);
            fin.close();
        }

        public void FileWriteAndRead() throws IOException
        {
            try {
                while (true) {
                    File f = new File("new_file.txt");
                    if (!f.equals(null)) f.createNewFile();
                    else System.out.println("Файл уже создан.");
                    FileWriter fw = new FileWriter(f);
                    FileReader fr = new FileReader(f);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("string1");
                    bw.newLine();
                    bw.write("string2");
                    bw.newLine();
                    bw.write("string3");
                    bw.newLine();
                    bw.close();
                    BufferedReader br = new BufferedReader(fr);
                    String str;

                    while (br.ready()) {
                        str = br.readLine();
                        System.out.println(str);
                    }
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(500);
                    fw.close();
                    fr.close();
                }
            }
            catch (InterruptedException e)
            {
                System.out.println("Exception file:write or read");
            }
        }
    }

    public static class StudyString {
        public void func_string() throws Exception
        {
            char ch[] = {'a','b','c','d','e','f'};
            String str = new String(ch);
            str += " hello ";
            str += 10.9055;
            str = str.toUpperCase();
            System.out.println(str);
            char c1 = str.charAt(3);
            System.out.println("Symbol 3 string = "+c1);
            int end = 10, start = 5;
            char ch1[] = new char[end-start];
            str.getChars(start,end,ch1,0);
            System.out.println(ch1);
            String s1 = "hewwo";
            String s2 = "hello";
            for (int i=0;i<s2.length();i++) System.out.println(s2.charAt(i));
            String s3 = s1.replace('w','l');
            s3 = s3.replaceAll("hello","goodbye");
            System.out.println(s3);
            System.out.println(s3.equals(s2)); //сравнение строк
            String s4 = "          Hello, my friend !!!".trim();
            System.out.println(s4);
            StringBuffer sb = new StringBuffer(s4);
            System.out.println(sb.charAt(7));
            String s5 = " dear";
            sb.insert("Hello, my".length(),s5);
            System.out.println(sb);
            int num = 12345;
            System.out.println(num+" двоичный = "+Integer.toBinaryString(num));
            System.out.println(num+" восьмиричный = "+Integer.toOctalString(num));
            System.out.println(num+" шестнадцатир-й = 0x"+Integer.toHexString(num));
            String s6 = "Hello my very good string";
            StringTokenizer st = new StringTokenizer(s6);
            String s7;
            try {
                    for (int i = 0; i < 5; i++) {
                        s7 = st.nextToken();
                        if (s7.equals("good")) System.out.println("Its good string");
                        else System.out.println(s7);
                    }
            }
            catch (Exception e) {
                System.out.println("Exception good string");
            }
            StringBuilder stringBuilder = new StringBuilder("string builder ");
            stringBuilder.append("version 1.0");
            System.out.println(stringBuilder);
        }
    }

    public static class StudyApplet extends Applet {
        public void paint(Graphics g) {
            g.drawString("Simple Applet",20,20);
        }
    }

    public static class StudyExec {
        public void func_exec() {
            Runtime r = Runtime.getRuntime();
            Process p = null;
            try {
                p = r.exec("calc");
            }
            catch (Exception e)
            {
                System.out.println("Error exec.");
            }
        }
    }

    public static  class StudyCollection {
        public void func_collection() {

            Vector v = new Vector(3,2);
            v.addElement(1);
            v.addElement(5.45);
            v.addElement("Hello");
            System.out.println(v);

            Stack st = new Stack();
            for (int i=0;i<10;i++) st.addElement(i);
            System.out.println(st);

            Dictionary d = new Hashtable();
            d.put("Ul_obl1","Ulyanovsk");
            d.put("Ul_obl2","Veshkaima");
            //int dd = (int)d.get("two");
            System.out.println(d);
        }
        public void func_list() {
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<100;i++) list.add(i);
            list.remove(10);
            list.forEach(e -> System.out.print(e+" "));

        }
    }

    public static class HomeWork10_2 {
        public void func_hw() throws IOException {

           FileReader fr = new FileReader("file_text.dat");
           FileWriter fw = new FileWriter("file_text.dat",true);

           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedReader br_file = new BufferedReader(fr);

           String str, str_read;
           String zag, manual,prior,date_create,date_end,maker,ready_marker;

           String str_start;
           str_start = br_file.readLine();
           System.out.println(str_start);

           do {
               System.out.println("Заголовок: "); zag = br.readLine();
               if (zag.equals("stop"))
               {
                   fw.close();
                   fr.close();
                   return;
               }

               System.out.println("Описание: "); manual = br.readLine();
               System.out.println("Приоритет: "); prior = br.readLine();
               Calendar calendar = Calendar.getInstance();
               Date date = new Date();
               date_create = " Дата начала: ";
               date_create += calendar.get(Calendar.DATE);
               date_create+="-";
               date_create += calendar.get(Calendar.MONTH);
               date_create+="-";
               date_create += calendar.get(Calendar.YEAR);
               date_create+=" ";
               date_create += calendar.get(Calendar.HOUR);
               date_create+=":";
               date_create += calendar.get(Calendar.MINUTE);
               date_create+=":";
               date_create += calendar.get(Calendar.SECOND);
               str = "Заголовок: "+zag+" Описание: "+manual+" Приоритет: "+prior+date_create;

               fw.write(str);
               fw.write("\n");
               str_read = br_file.readLine();

                System.out.println(str_read);
           }
           while (!str.equals("stop"));
        }
    }

    public static class MySerial implements Serializable {
            String s, s1;
            int i;
            double d;

            public MySerial() {}

            public MySerial(String s, int i, double d, String s1) {
                this.s = s;
                this.i = i;
                this.d = d;
                this.s1 = s1;
            }

            public String toString() {
                return "s=" + s + "; i=" + i + "; d=" + d+"; s1="+s1;
            }

            public void funcSerial() {
                //сериализация объекта
                try {
                    MySerial ob1 = new MySerial("Hello, my friend", -7, 1.234567,"Goodbye, America\n");
                    System.out.println("ob1=" + ob1);
                    FileOutputStream fos = new FileOutputStream("serial",true);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(ob1);
                    oos.flush();
                    oos.close();
                } catch (Exception e) {
                    System.out.println("Exception serialize: " + e);
                    System.exit(0);
                }
                //десерилизация объекта
                try {
                    MySerial ob2;
                    FileInputStream fis = new FileInputStream("serial");
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    ob2 = (MySerial) ois.readObject();
                    ois.close();
                    System.out.println("ob2=" + ob2);
                } catch (Exception e) {
                    System.out.println("Exception deserialize: " + e);
                    System.exit(0);
                }
            }
            public void serialDes() {

            }
    }

    public static class StudyUdpClientServer {
        public static int serverPort = 666;
        public static int clientPort = 999;
        public static int buffer_size = 1024;
        public static DatagramSocket ds;
        public static byte buffer[] = new byte[buffer_size];

        public static void TheServer() throws Exception {
            int pos = 0;
            while (true) {
                int c = System.in.read();
                switch (c) {
                    case -1:
                        System.out.println("Server quit.");
                        return;
                    case '\r':
                        break;
                    case '\n':
                        ds.send(new DatagramPacket(buffer,pos, InetAddress.getLocalHost(),clientPort));
                        pos = 0;
                        break;
                    default:
                        buffer[pos++] = (byte)c;
                        break;
                }
            }
        }

        public static void TheClient() throws Exception {
            while (true) {
                DatagramPacket p = new DatagramPacket(buffer,buffer.length);
                ds.receive(p);
                System.out.println(new String(p.getData(),0,p.getLength()));
            }
        }

        public static void StartClientOrServer(int args) throws Exception {
            if (args == 49) {
                System.out.println("Start server");
                ds = new DatagramSocket(serverPort);
                TheServer();
            }
            else {
                System.out.println("Start client");
                ds = new DatagramSocket(clientPort);
                TheClient();
            }
        }
    }

//    public static class StudyDrawWindow extends Frame {
//        public StudyDrawWindow() {
//            //addKeyListener();
//        }
//        class MyKeyAdapter extends KeyAdapter {
//            StudyDrawWindow sdw;
//            public KeyAdapter
//        }
//        public void paint(Graphics g) {
//            System.out.println("Start PAINT");
//            //g.drawRect(100,100,200,250);
//            Button jButton = new Button("Enter");
//            jButton.paint(g);
//            jButton.setVisible(true);
//            jButton.setLabel("Button");
//            jButton.setSize(90,50);
//            jButton.setBackground(Color.BLUE);
//            add(jButton);
//        }
//    }

    //public class AppWindow extends Frame {
        String keymsg = "";
        String mousemsg = "";
        int mouseX = 30, mouseY = 30;

        public StudyBaseJava() {
            addKeyListener(new MyKeyAdapter(this));
            addMouseListener(new MyMouseAdapter(this));
            addWindowListener(new MyWindowAdapter());
        }

        public void paint(Graphics g) {
            g.drawString(keymsg,10,40);
            g.drawString(mousemsg,mouseX,mouseY);
            //g.drawLine(10,100,100,10);
        }

        class MyKeyAdapter extends KeyAdapter {
            StudyBaseJava appWindow;
            public MyKeyAdapter(StudyBaseJava appWindow) {
                this.appWindow = appWindow;
            }
            public void keyTyped(KeyEvent ke) {
                appWindow.keymsg += ke.getKeyChar();
                appWindow.repaint();
            };
        }

        class MyMouseAdapter extends MouseAdapter {
            StudyBaseJava appWindow;
            public MyMouseAdapter(StudyBaseJava appWindow) {
                this.appWindow = appWindow;
            }
            public void mousePressed(MouseEvent me) {
                appWindow.mouseX = me.getX();
                appWindow.mouseY = me.getY();
                appWindow.mousemsg = "Mouse (X="+appWindow.mouseX+", Y="+appWindow.mouseY+")";
                appWindow.repaint();
            }
        }

        class MyWindowAdapter extends WindowAdapter {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        }

    public static class StudyFrame extends Frame {
            public StudyFrame() {
                super();
                setTitle("Main window");
                setBounds(100,100,400,400);
                setResizable(false);
                addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        System.out.println("Window open.");
                    }
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("Window closing.");
                    }
                    @Override
                    public void windowClosed(WindowEvent e) {
                        System.exit(0);
                    }
                    @Override
                    public void windowIconified(WindowEvent e) {
                        System.out.println("Window iconified.");
                    }
                    @Override
                    public void windowDeiconified(WindowEvent e) {
                        System.out.println("Window deiconified.");
                    }
                    @Override
                    public void windowActivated(WindowEvent e) {
                        System.out.println("Window activated.");
                    }
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        System.out.println("Window deactivated.");
                    }
                });
                setLayout(null);
                Panel panel = new Panel();
                panel.setBounds(10,30,300,300);
                panel.setBackground(Color.BLUE);
                panel.setLayout(new BorderLayout());
                Label label = new Label("Здесь могла быть ваша реклама.");
                label.setAlignment(Label.CENTER);
                panel.add(label,BorderLayout.CENTER);
                add(panel);
                Button button = new Button("Close");
                button.setBounds(50,350,90,30);
                button.addActionListener(ae->System.exit(0));
                add(button);
                setVisible(true);

                addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(0);
                    }
                });
            }
    }

    public static class StudyCollect {
        private String name;
        public double weight;
        private double price;

        public double getPrice() {
            return price;
        }
        public double getWeight() {
            return weight;
        }

        public StudyCollect() {}

        public StudyCollect(String name, double weight, double price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }
        @Override
        public String toString() {
            return this.name+" weight:"+this.weight+" price:"+this.price;
        }
        public void addToHash() {
            HashSet<StudyCollect> fishes = new HashSet<>();
            fishes.add(new StudyCollect("carp",3.5,80));
            fishes.add(new StudyCollect("trout",2.2,50));
            System.out.println(fishes);
        }
        public void addToMap() {
            Map<StudyCollect,Double> wtm = new WeakHashMap<>();
            StudyCollect s1 = new StudyCollect("ee1",1.5,120);
            StudyCollect s2 = new StudyCollect("salmon",1.7,170);
            StudyCollect s3 = new StudyCollect("trout",1.9,150);
            wtm.put(s1,120.0);
            wtm.put(s2,150.0);
            wtm.put(s3,170.0);
            System.out.println("Before:");
            for (Object eo : wtm.entrySet()) {
                Map.Entry e = (Map.Entry)eo;
                System.out.println(e.getKey()+"->"+e.getValue());
            }
            s2 = null;
            for (int i=0;i<10000;i++) {
                byte b[] = new byte[1000000];
                b = null;
            }
            System.out.println("After:");
            for (Object eo : wtm.entrySet()) {
                Map.Entry e = (Map.Entry)eo;
                System.out.println(e.getKey()+"->"+e.getValue());
            }
        }

        public void MyFunction() {
            List<StudyCollect> fishes = new ArrayList<>();
            fishes.add(new StudyCollect("ee1",1.5,120));
            fishes.add(new StudyCollect("salmon",1.7,170));
            fishes.add(new StudyCollect("trout",1.9,150));
            System.out.println("before sorting:");
            for (StudyCollect f : fishes) System.out.println(f);

            Collections.sort(fishes, new Comparator<StudyCollect>() {
                @Override
                public int compare(StudyCollect o1, StudyCollect o2) {
                    return (int)o1.getWeight()*100 - (int)o2.getWeight()*100;
                }
            });

            fishes.sort((f1,f2)->(int)f1.getWeight()*100-(int)f2.getWeight()*100);

            System.out.println("after sorting:");
            for (StudyCollect f : fishes) System.out.println(f);
      }
    }

    public static class StudyRecurcia {
        public void proba(int n) {
            System.out.println("n!=5 n =  " + n);
            if (n!=5) {
                proba(n + 1);
            }
            else {
                System.out.println("n==5 n =  " + n);
            }
        }
    }

//study interface
    interface Alpha {
            int NUMBER = 5;
            void set(int n);
            String get();
            default void show() {
                System.out.println("Result: "+get());
            }
    }
    public static class Betta implements Alpha {
            private int code;

        @Override
        public void set(int n) {
            if(n >= 0) code = n;
            else code = -n;
            System.out.println("Digital: "+code);
        }

        @Override
        public String get() {
            String res="|";
            int num = code;
            do {
                res = "|" + (num % NUMBER) + res;
                num /= NUMBER;
            }
            while (num > 0);
            return res;
        }

//        @Override
//        public void show() {
//            Alpha.super.show();
//        }
    }

    //лямбда-выражения
    interface Lambda {
            int get(String t);
    }

    //ссылки на метод объекта
    interface Alpha1 {
            void apply(String t);
    }
    interface Bravo1 {
            void display();
    }
    static class MyClass1 {
            String name;
            void set(String name) {
                this.name = name;
            }
            void show() {
                System.out.println("Name: "+this.name);
            }
    }

    interface Animal {
            int conf = 0;
            default void setId(int id) {System.out.println("id="+id);};
            default void setConfig(int conf) {System.out.println("config: "+conf);}
            void setYear(int year);
            void setName(String name);
            int getYear();
            String getName();
            String sayHello();
    }
    static class Dog implements Animal {
        String name = "";
        int year = 0;
        @Override
        public void setYear(int year) {
            this.year = year;
        }
        @Override
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public int getYear() {
            return this.year;
        }
        @Override
        public String getName() {
            return this.name;
        }
        @Override
        public String sayHello() {
            return "Hello, "+this.name+" "+this.year+" years";
        }
    }

    public static void main(String[] args) throws IOException, Exception, InterruptedException
     {
        String str = "Программируем на Java";
        char[] symbs = new char[12];
        "Изучаем язык Pascal".getChars(0,8,symbs,0);
        str.getChars(str.length()-4,str.length(),symbs,8);
        System.out.println(symbs);
        for (int k=str.length()-1; k>=0; k--) {
            System.out.print("|"+str.charAt(k));
        }
        System.out.println("|");
        byte[] nums;
        nums = "Java".getBytes();
        System.out.println(Arrays.toString(nums));
        symbs = "Java".toCharArray();
        System.out.println(Arrays.toString(symbs));

         Dog dog = new Dog();
         dog.setName("Bobik");
         dog.setYear(7);
         System.out.println(dog.sayHello());

         //лямбда
            Lambda A = t ->  t.length();
            Lambda B = t -> {
                int res=0;
                for (int i=0;i<t.length();i++) {res += t.charAt(i); System.out.println("код символа "+t.charAt(i)+" : "+(int)t.charAt(i));}
                return res;
            };
            String t = "Java";
            System.out.println("Длина текста: "+A.get(t));
            System.out.println("Сумма кодов символов в строке: "+B.get(t));
            //ссылка на метод объекта
         MyClass1 obj = new MyClass1();
         Alpha1 A1 = obj::set;
         Bravo1 B1 = obj::show;
         A1.apply("Red");
         obj.show();
         obj.set("Yellow");
         B1.display();
         obj = new MyClass1();
         obj.set("Green");
         B1.display();
         A1.apply("Blue");
         obj.show();
         B1.display();





        //PrintString printString = new PrintString();
        //printString.print_string();
        //printString.func_exception();



        //StudyString s = new StudyString();
        //s.func_string();

//         StudyExec ex = new StudyExec();
//         ex.func_exec();

//         StudyCollection sc = new StudyCollection();
//         sc.func_collection();

//         HomeWork10_2 hw = new HomeWork10_2();
//         hw.func_hw();

//         MySerial mySerial = new MySerial();
//         mySerial.funcSerial();

//         Scanner sc = new Scanner(System.in);
//         String arg = sc.toString();
//         System.out.println("My argc:");
//         System.out.println(arg);



//         System.out.println("Enter config: ");
//         int set = System.in.read();
//         System.out.println(set);
//         StudyUdpClientServer ss = new StudyUdpClientServer();
//         ss.StartClientOrServer(set);


//         StudyDrawWindow frame = new StudyDrawWindow();
//         frame.setSize(500,500);
//         frame.setTitle("Window");
//         frame.setVisible(true);
         //frame.paint(frame.getGraphics());

//         java_base.Untitled appWin = new java_base.Untitled();
//         appWin.setSize(new Dimension(300,200));
//         appWin.setTitle("Window Application");
//         appWin.setVisible(true);
//         appWin.setLocation(500,300);

//         StudyString studyString = new StudyString();
//         studyString.func_string();

//         int a = 111;
//         int b = 222;
//         System.out.println("Before: a="+a+" b="+b);
//         b = (a += b) - b;
//         //b = a - b;
//         a -= b;
//         System.out.println("After: a="+a+" b="+b);

         //StudyCollect studyCollect = new StudyCollect();
         //studyCollect.MyFunction();

//         StudyCollection st = new StudyCollection();
//         st.func_list();


//         StudyRecurcia test = new StudyRecurcia();
//         test.proba(0);

         System.out.println("Main thread: "+Thread.currentThread().getName());
         StudyThread s1 = new StudyThread("One",1);
         StudyThread s2 = new StudyThread("Two",2);
         StudyThread s3 = new StudyThread("Three",3);
         try {
             if (s1.isAlive()) s1.join();
             if (s2.isAlive()) s2.join();
             if (s3.isAlive()) s3.join();
         }
         catch (Exception e) {
             System.out.println("Exception join thread");
         }

         //StudyThread studyThread1 = new StudyThread();
         //studyThread1.showThread();

         Betta betta = new Betta();
         System.out.println("NUMBER: "+Alpha.NUMBER);
         betta.set(116);
         betta.show();

     }

}
