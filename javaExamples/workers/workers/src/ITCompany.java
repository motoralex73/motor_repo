import many_workers.Employer;
import many_workers.Role;
import many_workers.Worker;

import java.util.Objects;

public class ITCompany extends EntityManager<Employer<Role>>{
    private String name;

    public String getName() {
        return name;
    }

    public ITCompany(String companyName, int maxEmployerCount) {
        super(maxEmployerCount, Employer.class);
        this.name = companyName;
    }

    public void startWork() {
        for (int i=0;i<this.getSize();i++) {
            Employer[] workers = this.getEntities();
            Employer worker = workers[i];
            worker.work();
            System.out.println("worker role: "+worker.getName()+" "+ worker.getRole());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCompany company = (ITCompany) o;
        return Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ITCompany{" +
                "name='" + name + '\'' +
                '}';
    }
}
