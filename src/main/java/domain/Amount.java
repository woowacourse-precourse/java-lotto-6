package domain;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public void printAmount() {
        System.out.print(amount);
    }

}
