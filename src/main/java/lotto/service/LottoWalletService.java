package lotto.service;

import lotto.model.LottoBonusNumber;
import lotto.model.LottoWallet;
import lotto.model.LottoWinningNumbers;

public class LottoWalletService {

    private LottoWallet lottoWallet = null;
    private LottoWinningNumbers winningNumbers = null;
    private LottoBonusNumber bonusNumber = null;

    /**
     * 사용자의 로또 지갑을 저장한다.
     *
     * @param wallet
     */
    public void saveLottos(LottoWallet wallet) {
        this.lottoWallet = wallet;
    }

    public void saveRecentWinningNumbers(LottoWinningNumbers winningNumbers, LottoBonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
