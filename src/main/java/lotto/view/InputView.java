package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String NON_NUMERIC_INPUT_ERROR_MESSAGE = "[ERROR] 숫자 이외의 문자 입력은 불가합니다.";
    
    public int inputAmount() {
        System.out.println(INPUT_LOTTO_AMOUNT);
        return convertToInt(Console.readLine());
    }
    
    private int convertToInt(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_ERROR_MESSAGE);
        }
    }
}
