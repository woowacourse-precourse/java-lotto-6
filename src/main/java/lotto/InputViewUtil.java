package lotto;

public class InputViewUtil {
    public static int getValidAmount(String input) throws IllegalArgumentException {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER.getMessage());
        }

        if (amount % LottoManagement.PRICE_LOTTO != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_LOTTO_PRICE.getMessage());
        }
        return amount;
    }
}
