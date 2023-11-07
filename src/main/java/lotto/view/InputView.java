package lotto.view;


import static lotto.utils.Message.PURCAHSE_AMOUNT_LOTTO;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String buyLotto() {
        System.out.println(PURCAHSE_AMOUNT_LOTTO);
        return Console.readLine();
    }

}
