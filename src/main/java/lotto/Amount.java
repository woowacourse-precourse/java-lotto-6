package lotto;

public class Amount {
    public static int calAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new ExceptionClass(message.INPUT_AMOUNT_EXCEPTION);
        }
        return amount / 1000;
    }
}
