package many_workers;

public class Proger extends Employer<Role>{
    private String lang;
    public Proger(String name, int age, String lang) {
        super(name,age,Role.Proger);
        this.lang = lang;
    }

    @Override
    public void work() {
        System.out.println(this.getName()+" writing on"+lang);
    }

}
