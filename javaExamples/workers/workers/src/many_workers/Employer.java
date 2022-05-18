package many_workers;

public abstract class Employer<T> implements Worker {

    private String name;
    private int age;
    private T role;

    public Employer(String name, int age, T role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public T getRole() {
        return role;
    }

    public void setRole(T role) {
        this.role = role;
    }

}
