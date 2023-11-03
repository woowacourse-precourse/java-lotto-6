package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String COST_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 입력값이 숫자가 아닙니다.";

    public static int getPurchaseLottoCost() {
        String cost = Console.readLine();
        return costConvertToInt(cost);
    }

    private static int costConvertToInt(String cost) {
        try {
            return Integer.parseInt(cost);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COST_NOT_INTEGER_ERROR_MESSAGE);
        }
    }
}
