package lotto;

public class PlayerLottoAmount {
    private static final int LOTTO_MIN_PRICE = 1000;
    private final int amount;

    public PlayerLottoAmount(String amount) {
        int amountNum = validateNumber(amount);
        validateAmount(amountNum);
        this.amount = amountNum;
    }

    public int calculateLottoCount() {
        return amount / LOTTO_MIN_PRICE;
    }


    private void validateAmount(int amount) {
        validateNatural(amount);
        validateDivisible(amount);
    }

    private static int validateNumber(String amount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            ErrorMessage.numberException();
            throw new IllegalArgumentException();
        }
    }


    private void validateNatural(int amount) {
        if (amount <= 0) {
            ErrorMessage.naturalException();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int amount) {
        if (amount % LOTTO_MIN_PRICE != 0) {
            ErrorMessage.divisibleException();
            throw new IllegalArgumentException();
        }
    }

}
