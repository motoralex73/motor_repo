package java_collection;

public class StudyCollection {

//1.обобщенные типы данных
static class ClassAllStaticMethod {
    int code;

    public ClassAllStaticMethod() {
    }
    public ClassAllStaticMethod(int code) {
        this.code = code;
    }
    @Override
    public String toString() { //переопределение метода toString для распечатки объектов класса
        return "toString() " +this.code;
    }
}

 static class ClassAllStaticMethodDemo {
    static <T> void show(T[] a) {
        for (int i=0;i<a.length;i++) System.out.print("|"+a[i]);
        System.out.println("|");
    }
     static <T> void showWithType(T a) {
         System.out.println("Значение: "+a);
     }
    static <T> String getText(T a, int n) {
        String res = n+": ";
        res += a;
        return res;
    }
    static <T,U> T getArg(T x, T y, U z) {
        int val = z.toString().length();
        if (val % 2 == 0) return x;
        else return y;
    }
    void allStaticMethodDemo() {
        Integer[] nums = {1,3,5,7,9,11,13};
        Character[] symbs = {'A','B','C','D'};
        String[] txt = {"Alpha","Bravo","Charlie"};
        show(nums);
        show(symbs);
        show(txt);
        System.out.println(getText('A',1));
        System.out.println(getText("Alpha",2));
        System.out.println(getText(100,3));
        ClassAllStaticMethod classAllStaticMethod = new ClassAllStaticMethod(200);
        System.out.println(getText(classAllStaticMethod,4));
        String A = getArg("Alpha","Bravo",classAllStaticMethod);
        ClassAllStaticMethod B = getArg(new ClassAllStaticMethod(300), new ClassAllStaticMethod(400),1234);
        Integer C = getArg(123,321,"Hello");
        System.out.println("A: "+A);
        System.out.println("B: "+B.toString());//автоматом вызывается переопределенный метод toString, вот так B.toString()
        System.out.println("C: "+C);
        ClassAllStaticMethod c1 = new ClassAllStaticMethod();
        System.out.println(c1+" no arg");
        ClassAllStaticMethodDemo.<Double>showWithType(123.0);
    }
}

public static void func1() {
    ClassAllStaticMethodDemo classAllStaticMethodDemo = new ClassAllStaticMethodDemo();
    classAllStaticMethodDemo.allStaticMethodDemo();
}

//2.обобщенный суперкласс
static class PathernClass<T,U> {
    T value;
    U code;
    void set(T value, U code) {
        this.value = value;
        this.code = code;
    }
    void show() {
        System.out.println("value = "+value);
        System.out.println("code = "+code);
    }
}
//обобщенный подкласс
static class PathernAlpha<T> extends PathernClass<T,String> {}
static class PathernBravo extends PathernClass<Character,Integer> {}

public static void func2() {
    PathernClass<String,Character> obj = new PathernClass<>();
    obj.set("PathernClass",'D');
    obj.show();
    PathernAlpha<Double> A = new PathernAlpha<>();
    A.set(123.0,"Alpha");
    A.show();
    PathernBravo B = new PathernBravo();
    B.set('B',321);
    B.show();
}

//3.обобщенный интерфейс
interface PathernInterface<T,U> {

        void set(T value, String code);
        void set(T value, U code);
  //      void set(Character value, Integer code);
        void show();
    }
    //обобщенные классы от интерфейсов
    static class PathernAlphaInterface<T,String> implements PathernInterface<T,String> {
        T value;
        String code;

        @Override
        public void set(T value, java.lang.String code) {
            this.value = value;
            this.code = (String) code;
        }

        @Override
        public void set(T value, String code) {
            this.value = value;
            this.code = code;
        }

        @Override
        public void show() {
            System.out.println("A value = "+value);
            System.out.println("A code = "+code);
        }
    }
    static class PathernBravoInterface implements PathernInterface<Character,Integer> {
        Character value;
        Integer code;

        @Override
        public void set(Character value, String code) {

        }

        @Override
        public void set(Character value, Integer code) {
            this.value = value;
            this.code = code;
        }

        @Override
        public void show() {
            System.out.println("B value = "+value);
            System.out.println("B code = "+code);
        }
    }

public static void func3() {
    PathernAlphaInterface p1 = new PathernAlphaInterface();
    p1.set(123,"Hello A");
    p1.show();
    PathernBravoInterface p2 = new PathernBravoInterface();
    p2.set('B',459);
    p2.show();
}

//4.ограничения на обобщенные параметры
    //обычные классы
static class Alpha {
    String name;
    Alpha(String name) {
        this.name = name;
    }
    void show() {
        System.out.println("1. "+name);
    }
}
static class Bravo extends Alpha {
    Bravo(String name) {
        super(name);
    }
    void show() {
        System.out.println("2. "+name);
    }
}
static class Charlie extends Bravo {
    Charlie(String name) {
        super(name);
    }
    void show() {
        System.out.println("3. "+name);
    }
}
//обобщенные классы
static class First<T extends U,U> {
    T code;
    U value;
    void set(T code, U value) {
        this.code = code;
        this.value = value;
    }
    U get(boolean t) {
        if (t) return code;
        else return value;
    }
}
static class Second<T extends Alpha> {
    T obj;
    Second(T obj) {
        this.obj = obj;
    }
    void display() {
        obj.show();
    }
}

public static void func4() {
    First<Bravo,Alpha> A = new First<>();
    A.set(new Bravo("Bravo"), new Alpha("Alpha"));
    A.get(false).show();
    A.get(true).show();
    Second<Charlie> B = new Second<>(new Charlie("Charlie"));
    B.display();
}

static public void main(String[] args) {
//1.обобщенные типы данных
    //func1();
//2.обобщенный суперкласс
    //func2();
//3.обобщенный интерфейс
    //func3();
//4.ограничения на обобщенные параметры
    func4();

}//main

}



