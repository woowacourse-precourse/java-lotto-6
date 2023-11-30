package lotto.service;

import lotto.domain.*;

public interface LottoGameService {
    PurchaseAmount parsePurchaseAmount(String purchaseAmountInput);

    LottoCount computeLottoCount(PurchaseAmount purchaseAmount);

    Lottos generateLottos(LottoCount lottoCount);

    WinningNumbers parseWinningNumbers(String winningNumbersInput);

    BonusNumber parseBonusNumber(String bonusNumberInput);

    Winnings countMatchingNumbers(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber);

    ReturnRate getReturnRate(PurchaseAmount purchaseAmount, Winnings winnings);
}
