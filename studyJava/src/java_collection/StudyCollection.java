package java_collection;

import jdk.dynalink.beans.StaticClass;

import java.util.*;

public class StudyCollection {

//1.обобщенные типы данных (Generics)
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

//5.Коллекции
//Collection - интефейсы. Collections, Arrays - классы, описывают методы для коллекций, такие как sort() и т.д.
static void studyCollection() {
    Collection collection = new ArrayList();
    collection.add("1");
    collection.add("2");
    collection.add("3");
    collection.remove("2");
    Iterator iterator = collection.iterator();
    while (iterator.hasNext()) System.out.print(" "+iterator.next()); System.out.println(";");
    for (Object o : collection) System.out.print(" "+o); System.out.println(";");

    List l1 = new ArrayList(); //список на основе индексов
    Set s1 = new HashSet();    //множество
    Queue q1 = new PriorityQueue(); //очередь FIFO, LIFO (стек)
    Map m1 = new HashMap();    //коллекция ключ-значение

    l1.add("1");
    l1.add(collection);
    l1.add(1,"2");
    l1.set(1,"3");
    System.out.println(l1);

    q1.offer(5);
    q1.offer(6);
    Iterator i = q1.iterator();
    //poll - перебирает и удаляет, peek - не удаляет.
    while (i.hasNext()) System.out.println(q1.poll());
    System.out.println("count element = "+q1.size());
    //set - добавляет только НЕ повторяющиеся объекты
    //map
    m1.put("one",1);
    System.out.println("map = "+m1.get("one"));
//коллекции упорядоченные(LinkedHashSet) и неупорядочные(HashSet), отсортированные
}

//6. Сортировка коллекций
static public void sortCollection() {
    Set s1 = new TreeSet();//отсортированный
    s1.add("2");
    s1.add("5");
    s1.add("3");
    s1.add("3");
    for (Object o : s1) System.out.print(o+" "); System.out.println();
    Set s2 = new TreeSet();
    s2.add(new Person(4));
    s2.add(new Person(1));
    s2.add(new Person(7));
    for (Object o : s2) System.out.println(o+" ");
}

static class Person implements Comparable<Person> {
        //наследуем интерфейс Comparable для сортировки по возрасту
        int age;
        public Person(int age) {
            this.age = age;
        }
        @Override
        public int compareTo(Person o) {
            return this.age - o.age;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    '}';
        }
}

//7. List - списки
public static void studyList() {
    List list1 = new ArrayList(); //работает на основании массива, DEFAULT_CAPACITY=10,size=0. Быстрый.
    List list2 = new Vector(); //копия ArrayList, но синхронизированный
    List list3 = new LinkedList();//наследует очереди, двунаправленный список, добавляет вначало или в конец, хранит информацию Node,
    // т.е. ссылками на следующий и предыдущий элементы (next, prev). Хорош для очередей, когда постоянно что-то удаляется-добаляется в список.
    for (int i=0;i<3;i++) {list1.add(5); System.out.print(list1.get(i)+" ");}
}

//8. Queue - очереди (кью)
public static void studyQueue() {
    Queue queue1 = new LinkedList(); //FIFO
    Queue queue2 = new PriorityQueue(); //отсортированная очередь. 3-2-1 отсортирует как 1-2-3,
    //сортировка происходит каждый раз при добавлении нового элемента
    for (int i=0;i<10;i++) queue1.add(i);
    while (queue1.size() > 0) System.out.print(queue1.poll()+" "); System.out.println();
    //пример сортировки
    List l = (List)queue1;
    Collections.sort(l);
}

//9. Map - коллекции по типу ключ-значение
public static void studyMap() {
    Map map1 = new HashMap(); //хранит свои объекты на основании хэша (в определенной ячейке памяти)
    Map map2 = new Hashtable(); //как HashMap, только синхронизированный
    Map map3 = new LinkedHashMap(); //гарантирует сохранения порядка элементов коллекции (так как добавлялось в коллекцию)
    Map map4 = new TreeMap(); //отсортированный список, сортируется по алгоритму red-black
    map1.put(1,"one");
    map1.put(3,"three");
    map1.put(2,"two");
    System.out.println(map1.get(3));
    Set set = map1.entrySet();
    for (Object o : set) System.out.println(o);
}

//10. Set - множества
public static void studySet() {
    Set set1 = new HashSet(); //устроен на основе HashMap, значения не повторяются
    Set set2 = new LinkedHashSet();
    Set set3 = new TreeSet();
    set1.add(2); set1.add(1); set1.add(1); set1.add(2);
    for (Object o : set1) System.out.println(o);
}

//11. Inner-классы (внутренние классы)
private int ppp=123;
class Inner{
    private int k = 10;
    void show() {
        System.out.println(ppp);
    } //внутренние классы имеют доступ к переменным внешнего класса, даже приватным
}
void method() {
    Inner inner = new Inner();
    inner.show();
}
void innerMethod() {
    class NewInner {
        void show() {
            System.out.println("Hello class into the method");
        }
    }
    NewInner newInner = new NewInner();
    newInner.show();
}


public static void main(String[] args) {
//1.обобщенные типы данных
    //func1();
//2.обобщенный суперкласс
    //func2();
//3.обобщенный интерфейс
    //func3();
//4.ограничения на обобщенные параметры
    //func4();
//5.коллекции
    //studyCollection();
//6.сортировка коллекций
    //sortCollection();
//7.list список
    //studyList();
//8.queue очереди
    //studyQueue();
//9.map - ключ-значение
    studyMap();
//10.Inner-классы (внутренние классы)
    //StudyCollection studyCollection = new StudyCollection();
    //studyCollection.method();
    //Inner inner = new Inner();
    //inner.show();
    //innerMethod();
}//main

}//class StdyCollection



