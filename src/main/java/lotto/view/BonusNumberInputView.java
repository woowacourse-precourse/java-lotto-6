package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BonusNumberInputView {
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자 형식으로 입력해야 합니다.";

    public Integer readBonusNumberInput() {
        try {
            String line = readLine();
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }
}
