package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputPurchaseAmount() {
        return inputForMessage(Message.PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
    }

    public String inputWinningLotto() {
        return inputForMessage(Message.WINNING_LOTTO_INPUT_MESSAGE.getMessage());
    }

    public String inputBonusNumber() {
        return inputForMessage(Message.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    private String inputForMessage(String message) {
        System.out.println(message);

        return input();
    }

    private String input() {
        return Console.readLine();
    }
}
