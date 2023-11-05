package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ONLY_NUMERIC_INPUT_FOR_MONEY = "[ERROR] 구입금액은 숫자만 입력 가능합니다.";
    public int inputMoney() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMERIC_INPUT_FOR_MONEY);
        }
    }
}
