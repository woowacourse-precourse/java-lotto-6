package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        return inputForMessage(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public String inputWinningLotto() {
        return inputForMessage(WINNING_LOTTO_INPUT_MESSAGE);
    }

    public String inputBonusNumber() {
        return inputForMessage(BONUS_NUMBER_INPUT_MESSAGE);
    }

    private String inputForMessage(String message) {
        System.out.println(message);

        return input();
    }

    private String input() {
        return Console.readLine();
    }
}
