package lotto.ui;

import lotto.domain.number.Lotto;
import lotto.domain.number.Number;
import lotto.domain.purchase.PurchaseAmount;

public interface InputReader {
    PurchaseAmount readPurchaseAmount();

    Lotto readWinningNumbers();

    Number readBonusNumber();

    void close();
}
