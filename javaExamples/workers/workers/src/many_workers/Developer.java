package many_workers;

public class Developer extends Employer<Role> implements Worker{
    private String lang;
    public Developer(String name, int age, String lang) {
        super(name,age,Role.Developer);
        this.lang = lang;
    }
    @Override
    public void work() {
        System.out.println(getName()+" building "+lang+" project");
    }
}
