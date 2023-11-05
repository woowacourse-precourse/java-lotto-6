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
        long lottoCount = application.calculateLottoPurchaseCount();
        application.printLottoPurchaseCount(lottoCount);
    }

    private long calculateLottoPurchaseCount() {
        long purchasePrice = getPurchasePrice();
        return purchasePrice / PURCHASE_PRICE_UNIT;
    }

    private long getPurchasePrice() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String purchasePrice = Console.readLine();
            System.out.println();
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

    private void printLottoPurchaseCount(long lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }
}
