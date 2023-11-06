package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.LottoMsg;

public class InputView {

    public int parseInputFromUserInteger() {
        System.out.println(LottoMsg.LOTTO_BUY_PRICE.getMsg());
        return Integer.parseInt(Console.readLine());
    }

    public String commonInput() {
        return Console.readLine();
    }
}
