package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_PURCHASE_AMOUNT = 1000;
    private static final int MAX_PURCHASE_AMOUNT = 10000000;
    private static final String VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE = "[ERROR] 공백이 없는 값이어야 합니다.";
    private static final String VALIDATE_STRING_TO_INT_MESSAGE = "[ERROR] 입력 값은 유효한 범위의 숫자여야 합니다.";

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validatePurchaseAmount(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public void validatePurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.contains(" ")) {
            throw new IllegalArgumentException(VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
        }
        try {
            if (Integer.parseInt(purchaseAmount) % MIN_PURCHASE_AMOUNT != 0) {
                throw new IllegalArgumentException("[ERROR] 입력 값은 1,000의 배수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_STRING_TO_INT_MESSAGE);
        }
        int purchaseAmountNumber = Integer.parseInt(purchaseAmount);
        if (purchaseAmountNumber < MIN_PURCHASE_AMOUNT || purchaseAmountNumber > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 입력 값은 1,000이상, 1,000,000이하의 숫자여야 합니다.");
        }
    }

    public List<Integer> inputAnswerNumber() {
        String inputAnswer = Console.readLine();
        validateInputAnswer(inputAnswer);

        List<Integer> answerNumber = new ArrayList<>();
        return answerNumber;
    }

    public void validateInputAnswer(String inputAnswer) {
        if(inputAnswer.contains(" ")){
            throw new IllegalArgumentException(VALIDATE_CONTAIN_WHITE_SPACE_MESSAGE);
        }
    }
}
