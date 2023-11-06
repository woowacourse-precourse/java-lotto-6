package lotto.domain;

public class Player {
    private static final int LOTTO_MIN_PRICE = 1000;
    private static final String NUMBER_ERROR_MESSAGE = "숫자만 입력가능합니다.";
    private static final String NATURAL_ERROR_MESSAGE = "최소금액은 " + LOTTO_MIN_PRICE + "원 입니다.";
    private static final String DIVISIBLE_ERROR_MESSAGE = LOTTO_MIN_PRICE + "원 단위로 입력하세요.";
    private static int amount;

    public Player(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public int calculateLottoCount() {
        return amount/LOTTO_MIN_PRICE;
    }

    public void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    private static int validateNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateNatural(int amount) {
        if (amount < LOTTO_MIN_PRICE) {
            throw new IllegalArgumentException(NATURAL_ERROR_MESSAGE);
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_MIN_PRICE != 0) {
            throw new IllegalArgumentException(DIVISIBLE_ERROR_MESSAGE);
        }
    }

}
