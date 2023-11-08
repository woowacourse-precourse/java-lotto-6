package lotto;

public class Application {
    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        int money = purchase.totalCost();
        int amount = purchase.getAmount(money);
        System.out.println(amount);
    }
}
