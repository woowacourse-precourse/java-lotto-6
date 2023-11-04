package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public int inputBuyAmount() {
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        return InputValidator.validateBuyAmount(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return InputValidator.validateWinningNumbers(Console.readLine());
    }
}