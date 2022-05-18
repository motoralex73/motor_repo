import many_workers.*;

public class MainWorkers {
    public static void main(String[] args) {
        Proger proger = new Proger("Vasiy",23,"Python");
        Worker developer = new Developer("Petiy",37,"Java");

        ITCompany company = new ITCompany("Rostelecom",100);
        company.addEntities(proger);
        company.addEntities((Employer<Role>) developer);
        company.startWork();

        System.out.println("Company: "+company);
        ITCompany company2 = new ITCompany("Rostelecom",100);
        System.out.println(company.equals(company2));
    }
}
