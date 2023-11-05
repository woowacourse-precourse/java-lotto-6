package lotto;

import static lotto.resource.TextResourceProvider.INPUT_PURCHASE_AMOUNT_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT;
import static lotto.resource.TextResourceProvider.PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidPurchasedAmountException;

public class InputInterface {

    public long getPurchasedAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_TEXT);

        return getValidPurchasedAmount();

    }

    private long getValidPurchasedAmount() {
        try {
            String input = Console.readLine();
            long purchaseAmount = convertToPurchasedAmount(input);
            return purchaseAmount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return getValidPurchasedAmount();
        }
    }


    private static long convertToPurchasedAmount(String input) {
        try {
            long purchasedAmount = Long.parseLong(input);
            checkIfNegativeLong(purchasedAmount);
            checkIfDivisibleByLotteryPrice(purchasedAmount);
            return purchasedAmount;
        } catch (NumberFormatException e) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_CANNOT_CONVERT_TO_LONG_TEXT, input, e);
        }
    }

    private static void checkIfNegativeLong(long purchasedAmount) {
        if (purchasedAmount < 0) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_CANNOT_BE_NEGATIVE_LONG_TEXT, purchasedAmount);
        }
    }

    private static void checkIfDivisibleByLotteryPrice(long purchasedAmount) {
        if (purchasedAmount % 1000 != 0 || purchasedAmount == 0) {
            throw new InvalidPurchasedAmountException(PURCHASE_AMOUNT_MUST_BE_DIVIDE_BY_LOTTERY_PRICE_TEXT, purchasedAmount);
        }
    }


}
