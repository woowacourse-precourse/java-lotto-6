package lotto;

public class Amount {

    private static final int STANDARD_AMOUNT = 1000;
    private final int amount;

    public Amount(String amount) {
        validate(amount);
        this.amount = parseAmountToInt(amount);
    }

    private int parseAmountToInt(String amount) {
        return Integer.parseInt(amount);
    }

    private void validate(String amount) {
        try {
            int parsedAmount = parseAmountToInt(amount);

            if (parsedAmount < STANDARD_AMOUNT) {
                throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원 이상입니다.");
            }

            if (parsedAmount % STANDARD_AMOUNT != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액 단위는 1000원입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로 입력해야합니다.");
        }
    }

    public int getAmount() {
        return this.amount;
    }
}
