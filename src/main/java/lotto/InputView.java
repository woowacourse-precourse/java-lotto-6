package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String askPurchasePrice() {
        final String PROMPT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
        System.out.println(PROMPT_PURCHASE_PRICE);
        return Console.readLine();
    }

    public String askWinningNumbers() {
        final String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
        System.out.println(PROMPT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String askBonusNumber() {
        final String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
        System.out.println(PROMPT_BONUS_NUMBER);
        return Console.readLine();
    }
}
