public class Account {
    Customer customer;
    Integer amount;
    Integer id;
    Branch branch;
    AccountStatus accountStatus ;

    public Account() {
    }

    public Account(int amount, int id, String branch) {
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

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Account(Customer customer, Integer amount, Integer id, Branch branch, AccountStatus accountStatus) {
        this.customer = customer;
        this.amount = amount;
        this.id = id;
        this.branch = branch;
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "customer=" + customer +
                ", amount=" + amount +
                ", id=" + id +
                ", branch=" + branch +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
