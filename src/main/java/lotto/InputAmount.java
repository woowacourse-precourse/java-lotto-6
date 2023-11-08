package lotto;

public class InputAmount {
    public static int calculate(int amount) {
        if (amount % 1000 != 0) {
            throw new ApplicationException(ExceptionMessage.INPUT_AMOUNT_EXCEPTION);
        }
        return amount / 1000;
    }
}
