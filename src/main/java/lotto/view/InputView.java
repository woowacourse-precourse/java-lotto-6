package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final String SPACE = " ";

    public String inputPurchasePrice() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

}
