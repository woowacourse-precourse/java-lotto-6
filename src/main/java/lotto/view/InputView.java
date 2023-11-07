package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ERROR_PROMPT = "[ERROR] ";
    public int requestLottoPurchase() {
        int input;
        while (true) {
            try {
                input = Integer.parseInt(Console.readLine());
                validateLottoPurchase(input);
                break;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_PROMPT + "금액으로 숫자를 입력해주세요.");
            }
        }
        return input;
    }
    private void validateLottoPurchase(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PROMPT + "1000원 단위로 입력해주세요.");
        }
    }
}