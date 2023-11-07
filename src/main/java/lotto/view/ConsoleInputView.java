package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleInputView implements InputView {
    private static final String ASK_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private ConsoleInputView() {
    }

    private static class InputViewHolder {
        private static ConsoleInputView consoleInputView = new ConsoleInputView();
    }

    public static ConsoleInputView getInstance() {
        return InputViewHolder.consoleInputView;
    }

    @Override
    public String askPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT_MESSAGE);
        return getUserInput();
    }

    @Override
    public String askWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        return getUserInput();
    }

    @Override
    public String askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_MESSAGE);
        return getUserInput();
    }

    public String getUserInput() {
        return Console.readLine();
    }
}
