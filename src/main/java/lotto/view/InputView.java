package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLEASE_INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PLEASE_INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String PLEASE_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String getPurchasePrice() {
        System.out.println(PLEASE_INPUT_PURCHASE_PRICE);
        return Console.readLine();
    }

    public String getWinningNumbers() {
        System.out.println(PLEASE_INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(PLEASE_INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
