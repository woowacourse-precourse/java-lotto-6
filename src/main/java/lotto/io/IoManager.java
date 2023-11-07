package lotto.io;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PurchasePrice;

import java.util.function.Supplier;

public interface IoManager {

    PurchasePrice inputPurchasePrice();

    Lotto inputLotto();

    BonusNumber inputBonusNumber(Lotto lotto);

    <T> T read(Supplier<T> input);
}
