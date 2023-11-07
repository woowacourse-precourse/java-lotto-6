package lotto.view;

import lotto.domain.Money;

import static lotto.constant.message.OutputMessage.*;
public class OutputLottoCountView {
    public void OutputLottoCount(Money money) {
        System.out.printf(COUNT_LOTTO + "\n", money.getLottoCount());
    }
}
