package lotto.io;

import lotto.domain.lotto.BonusNumber;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.PurchasePrice;

import java.util.function.Supplier;

public interface IoManager {

    PurchasePrice inputPurchasePrice();

    Lotto inputLotto();

    BonusNumber inputBonusNumber(Lotto lotto);

    <T> T read(Supplier<T> input);
}
