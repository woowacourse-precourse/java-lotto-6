package lotto.domain;

public class Budget {
    private final int budget;
    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 숫자만 입력할 수 있습니다.";
    private static final String DIVIDE_EXCEPTION_MESSAGE = "[ERROR] 구입 금액은 %d원 단위로 나누어 떨어져야합니다.";
    private static final String MINIMUM_PRICE_EXCEPTION_MESSAGE = "[ERROR] 로또 구입 최소 금액은 %d원 입니다.";
    private static final int LOTTO_UNIT_PRICE = 1000;
    private static final int ZERO = 0;

    private Budget(int budget) {
        this.budget = budget;
    }

    public static Budget from(String inputBudget) {
        validateNumeric(inputBudget);
        int budget = Integer.parseInt(inputBudget);
        validateLowerPrice(budget);
        validateDivideResultIsZero(budget);
        return new Budget(budget);
    }

    private static void validateNumeric(String inputBudget) {
        try {
            Integer.parseInt(inputBudget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static void validateDivideResultIsZero(int budget) {
        if (budget % LOTTO_UNIT_PRICE != ZERO) {
            throw new IllegalArgumentException(String.format(DIVIDE_EXCEPTION_MESSAGE, LOTTO_UNIT_PRICE));
        }
    }

    private static void validateLowerPrice(int budget) {
        if (budget < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(String.format(MINIMUM_PRICE_EXCEPTION_MESSAGE, LOTTO_UNIT_PRICE));
        }
    }

    public int getCountOfLottoLines() {
        return budget / LOTTO_UNIT_PRICE;
    }

    public int getBudget() {
        return budget;
    }
}
