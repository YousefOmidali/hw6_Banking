public class Account {
    Customer customer;
    Integer amount;
    Integer id;
    String branch;

    public Account() {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public Account(Customer customer, Integer amount, Integer id, String branch) {
        this.customer = customer;
        this.amount = amount;
        this.id = id;
        this.branch = branch;
    }

    public Account(int amount, int id, String branch) {
    }

    @Override
    public String toString() {
        return "Account{" +
                "customer=" + customer +
                ", amount=" + amount +
                ", id=" + id +
                ", branch='" + branch + '\'' +
                '}';
    }
}
