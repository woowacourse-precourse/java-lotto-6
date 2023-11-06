package lotto.domain;

public class Money {
    private static final String TYPE_ERROR_MESSAGE = "숫자를 입력해 주세요.";
    private static final String RANGE_ERROR_MESSAGE = "최소 구입 금액은 %d원입니다.";
    private static final String DIVIDE_ERROR_MESSAGE = "로또 구입 금액은 %d원으로 나누어 떨어져야 합니다.";
    private static final String RATE_FORMAT = "%.1f";
    private static final int LOTTO_PRICE = 1000;

    private final int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money from(String inputAmount) {
        validateType(inputAmount);
        int amount = Integer.parseInt(inputAmount);
        validateRange(amount);
        validateDivideByLottoPrice(amount);
        return new Money(amount);
    }

    public int getLottoCount() {
        return amount / LOTTO_PRICE;
    }

    public String getProfit(int prizeMoney) {
        return String.format(RATE_FORMAT, (double) prizeMoney / amount * 100.0);
    }

    private static void validateType(String inputAmount) {
        try {
            Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private static void validateRange(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format(RANGE_ERROR_MESSAGE, LOTTO_PRICE));
        }
    }

    private static void validateDivideByLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(String.format(DIVIDE_ERROR_MESSAGE, LOTTO_PRICE));
        }
    }
}
