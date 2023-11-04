package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String WHITE_SPACE = " ";
    private static final String VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE = "[ERROR] 공백이 없는 값이어야 합니다.";
    private static final String VALIDATE_STRING_TO_INT_MESSAGE = "[ERROR] 입력 값은 숫자여야 합니다.";
    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        validateContainWhiteSpace(purchaseAmount);
        validateStringToInt(purchaseAmount);
    }

    public void validateContainWhiteSpace(String purchaseAmount){
        if(purchaseAmount.contains(WHITE_SPACE)){
            throw new IllegalArgumentException(VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
        }
    }
    public void validateStringToInt(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_STRING_TO_INT_MESSAGE);
        }
    }
}
