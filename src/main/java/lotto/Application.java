package lotto;

import lotto.service.Input;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amount = validateAmount(Input.getPurchaseAmount());
        validateDivisible(amount);

    }

    public static int validateAmount(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException e) {
          throw new IllegalArgumentException();
        }
    }

    public static void validateDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }
}
