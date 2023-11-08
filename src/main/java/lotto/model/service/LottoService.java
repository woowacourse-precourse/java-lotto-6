package lotto.model.service;

import lotto.model.dto.BonusNumber;
import lotto.model.dto.LottoResult;
import lotto.model.dto.LottoWallet;
import lotto.model.dto.PurchaseMoney;
import lotto.model.dto.WinningNumbers;

public class LottoService {

    private final LottoGenerator lottoGenerator;
    private final LottoChecker lottoChecker;

    public LottoService(LottoGenerator lottoGenerator, LottoChecker lottoChecker) {
        this.lottoGenerator = lottoGenerator;
        this.lottoChecker = lottoChecker;
    }

    public LottoWallet purchaseLotto(PurchaseMoney purchaseMoney) {
        return lottoGenerator.purchaseLotto(purchaseMoney);
    }

    public LottoResult findWinningLottos(LottoWallet lottoWallet, WinningNumbers winningNumber,
                                         BonusNumber bonusNumber) {
        return lottoChecker.findWinningLottos(lottoWallet, winningNumber, bonusNumber);
    }

}
