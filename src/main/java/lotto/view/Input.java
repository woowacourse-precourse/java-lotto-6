package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String AMOUNT_OF_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";


    public String askAmountOfLotto() {
        System.out.println(AMOUNT_OF_LOTTO_MESSAGE);
        return Console.readLine();
    }

    public String askWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String askBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
