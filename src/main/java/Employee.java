public class Employee {
    String firstName;
    String lastName;
    Integer NationalCode;
    String branch;
    String boss;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Integer nationalCode, String branch, String boss) {
        this.firstName = firstName;
        this.lastName = lastName;
        NationalCode = nationalCode;
        this.branch = branch;
        this.boss = boss;
    }

    public Employee(String first_name, String last_name, String branch, String boss) {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getNationalCode() {
        return NationalCode;
    }

    public void setNationalCode(Integer nationalCode) {
        NationalCode = nationalCode;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", NationalCode=" + NationalCode +
                ", branch='" + branch + '\'' +
                ", boss='" + boss + '\'' +
                '}';
    }
}
