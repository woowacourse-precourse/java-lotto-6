package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public long inputAmount() {
        String input = Console.readLine();
        validateAmount(input);
        return Long.parseLong(input);
    }

    private void validateAmount(String input) {
        validateStringToLongConversion(input);
    }

    private void validateStringToLongConversion(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 입력이 필요합니다.");
        }
    }
}
