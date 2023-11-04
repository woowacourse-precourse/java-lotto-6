package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateStringToInt(purchaseAmount);
    }

    public void validateStringToInt(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 숫자여야 합니다.");
        }
    }
}
