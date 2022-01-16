public class Account {
    String firstName;
    String lastName;
    Integer NationalCode;
    Integer amount;
    Integer id;
    String branch;

    public Account() {
    }

    public Account(String firstName, String lastName, Integer nationalCode, Integer amount, Integer id, String branch) {
        this.firstName = firstName;
        this.lastName = lastName;
        NationalCode = nationalCode;
        this.amount = amount;
        this.id = id;
        this.branch = branch;
    }

    public Account(int amount, int id, String branch) {
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Account{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", NationalCode=" + NationalCode +
                ", amount=" + amount +
                ", id=" + id +
                ", branch='" + branch + '\'' +
                '}';
    }
}
