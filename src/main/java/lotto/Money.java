package lotto;

public class Money {
    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        int amount = Integer.parseInt(input);
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0 이상이어야 합니다.");
        }
        return new Money(amount);
    }

    public int getAmount() {
        return amount;
    }
}
