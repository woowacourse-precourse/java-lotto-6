package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;
import lotto.common.SystemMessage;

public class InputBuyLottoView {

    public Integer insertCoin(){
        System.out.println(SystemMessage.INPUT_MONEY.getMessage());
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
