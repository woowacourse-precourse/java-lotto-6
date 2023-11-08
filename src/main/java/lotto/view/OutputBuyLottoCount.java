package lotto.view;

import lotto.common.SystemMessage;
import lotto.domain.Money;

public class OutputBuyLottoCount {
    public static void printBuyLotto(Money money){
        System.out.printf(SystemMessage.OUTPUT_MONEY_MESSAGE.getMessage(), money.getTicket());
    }
}
