public class Customers {
    protected String name;
    protected int balance;

    public Customers(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public boolean canBeAffordable(double amount) {
        return balance >= amount;
    }

    public void deductAmount(double amount) {
        this.balance -= amount;
    }

    public String getName() {
        return name;
    }

}
