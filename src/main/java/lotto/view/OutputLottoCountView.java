package lotto.view;

import lotto.domain.Money;

import static lotto.constant.message.OutputMessage.*;

public class OutputLottoCountView {
    public void outputLottoCount(Money money) {
        System.out.printf(NEWLINE + COUNT_LOTTO + NEWLINE, money.getLottoCount());
    }
}
