package lotto.view;


import static lotto.utils.Message.INPUT_BONUS_NUMBER;
import static lotto.utils.Message.INPUT_WINNING_NUMBER;
import static lotto.utils.Message.PURCAHSE_AMOUNT_LOTTO;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String buyLotto() {
        System.out.println(PURCAHSE_AMOUNT_LOTTO);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
