package lotto.vo;

public class Purchase {
    private int amount;

    private Purchase (int amount) {
        this.amount = amount;
    }

    public static Purchase createFromInput(String input) {
        int amount = Integer.parseInt(input);
        return new Purchase(amount);
    }
}
