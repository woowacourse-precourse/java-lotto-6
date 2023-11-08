package lotto.view;

import static lotto.view.LottoViewMessage.ASK_BUY_LOTTO;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.Money;

public class LottoView {
    public Money requestBuyLotto(){
        printMessage(ASK_BUY_LOTTO);
        return new Money(Console.readLine());
    }

    public void printMessage(LottoViewMessage lottoViewMessage) {
        System.out.println(lottoViewMessage.getViewMessage());
    }


}
