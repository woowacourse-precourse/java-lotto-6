package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.Message;
import lotto.exception.BelowMinimumPurchasePriceException;
import lotto.exception.InvalidPurchasePriceFormatException;
import lotto.exception.NonMultipleOfPriceUnitException;

public class Application {

    private static final long PURCHASE_PRICE_UNIT = 1000;
    private static final int EMPTY = 0;


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        System.out.println("구입금액을 입력해 주세요.");
        application.getPurchasePrice();

    }

    private long getPurchasePrice() {
        try {
            String purchasePrice = Console.readLine();
            validatePurchasePrice(purchasePrice);

            return Long.parseLong(purchasePrice);
        } catch (IllegalArgumentException exception) {
            printError(exception);
            return getPurchasePrice();
        }
    }

    private void validatePurchasePrice(String input) {
        try {
            long purchasePrice = Long.parseLong(input);
            if (purchasePrice < PURCHASE_PRICE_UNIT) {
                throw new BelowMinimumPurchasePriceException(purchasePrice);
            }
            if (purchasePrice % PURCHASE_PRICE_UNIT != EMPTY) {
                throw new NonMultipleOfPriceUnitException(purchasePrice);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidPurchasePriceFormatException(input);
        }
    }

    private void printError(IllegalArgumentException exception) {
        System.out.println(Message.ERROR_PREFIX + exception.getMessage());
    }
}
