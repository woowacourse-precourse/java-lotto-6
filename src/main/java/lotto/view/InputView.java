package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.MessageConstant.*;

public class InputView {
    public String inputMoney() {
        System.out.println(MONEY_INPUT);
        return Console.readLine();
    }

    public String inputWinningLotto() {
        System.out.println(LOTTO_INPUT);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(BONUS_INPUT);
        return Console.readLine();
    }
}
