package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_SPLITTER = ",";

    public String inputPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        return readLine();
    }

    public String[] inputWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        return readLine().split(INPUT_SPLITTER);
    }

    public String inputBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return readLine();
    }
}
