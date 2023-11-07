package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.message.InputMessage.*;

public class InputView {

    public String inputLottoAmount() {
        System.out.println(LOTTO_AMOUNT.getMessage());
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.println(WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
