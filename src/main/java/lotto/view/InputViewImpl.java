package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {

    public static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    @Override
    public String readPurchaseAmount() {
        return readLine(INPUT_AMOUNT_MESSAGE);
    }

    @Override
    public String readWinningNumbers() {
        return readLine(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    @Override
    public String readBonusNumber() {
        return readLine(INPUT_BONUS_NUMBER_MESSAGE);
    }

    protected String readLine(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
