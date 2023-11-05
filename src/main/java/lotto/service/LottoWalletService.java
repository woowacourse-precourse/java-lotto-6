package lotto.service;

import java.util.EnumMap;
import java.util.Map;
import lotto.exception.NonVariableException;
import lotto.model.LottoBonusNumber;
import lotto.model.LottoRank;
import lotto.model.LottoWallet;
import lotto.model.LottoWinningNumbers;

public class LottoWalletService {

    private LottoWallet lottoWallet = null;
    private LottoWinningNumbers winningNumbers = null;
    private LottoBonusNumber bonusNumber = null;
    private Map<LottoRank, Integer> ranks = new EnumMap<>(LottoRank.class);

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

    public void winningStatistics() {
        readyCheck();
    }

    /**
     * 로또 통계 계산에 필요한 데이터가 있는지 확인한다.
     */
    private void readyCheck() {
        if (lottoWallet == null) {
            throw new NonVariableException("lottoWallet");
        }
        if (winningNumbers == null) {
            throw new NonVariableException("winningNumbers");
        }
        if (bonusNumber == null) {
            throw new NonVariableException("bonusNumber");
        }
    }

}
