package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputService {

    public static int getUserInputForPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = validateAmount(readLine());
        validateAmountUnit(purchaseAmount);
        return purchaseAmount;
    }

    private static int validateAmount(String purchaseAmount) {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.CONVERT_AMOUNT_ERROR);
        }
    }

    private static void validateAmountUnit(int purchaseAmount) {
        checkAmountIsSufficient(purchaseAmount);
        checkAmountUnitIsCorrect(purchaseAmount);
    }

    private static void checkAmountUnitIsCorrect(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_AMOUNT_ERROR);
        }
    }

    private static void checkAmountIsSufficient(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_AMOUNT_ERROR);
        }
    }


}