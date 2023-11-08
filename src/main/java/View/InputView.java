package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getInputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String getInputLottoWinningNumber() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String getInputLottoBonusNumber() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

}
