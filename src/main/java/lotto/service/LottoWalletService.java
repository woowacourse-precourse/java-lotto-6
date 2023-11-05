package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.exception.NonVariableException;
import lotto.model.Lotto;
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

    /**
     * 당첨 통계를 반환한다.
     */
    public void winningStatistics() {
        readyCheck();
        initializeRanks();

        runAllCompare();
    }

    /**
     * 지갑의 로또로 등수를 확인한다.
     */
    private void runAllCompare() {
        for (Lotto lotto :
                lottoWallet.getLottos()) {
            LottoRank rank = lottoCompare(winningNumbers, bonusNumber, lotto);
            increaseRank(rank); // 랭킹 결과로 카운트를 올린다.
        }
    }

    /**
     * 랭킹 카운트를 올린다.
     *
     * @param rank
     */
    private void increaseRank(LottoRank rank) {
        int tempNumber = ranks.get(rank);
        ranks.put(rank, tempNumber + 1);
    }

    /**
     * 로또 등수 규정에 맞게 계산하여 랭킹을 반환한다.
     *
     * @param winningLotto     1등 로또
     * @param lottoBonusNumber 보너스 번호
     * @param userLotto        검증할 사용자 로또
     * @return LottoRank
     */
    private LottoRank lottoCompare(LottoWinningNumbers winningLotto, LottoBonusNumber lottoBonusNumber,
                                   Lotto userLotto) {
        double sameValue = 0;
        List<Integer> userNumbers = userLotto.getNumbers();

        for (int number : // 로또 번호 하나씩 비교해본다.
                winningLotto.getLottoNumbers()) {
            if (userNumbers.contains(number)) {
                sameValue++;
            }
        }

        int bonusNumber = lottoBonusNumber.getBonusNumber();
        if (sameValue == 5 && userNumbers.contains(bonusNumber)) {
            sameValue += 0.5; // 5개를 맞추고, 보너스도 맞추면 0.5점 증가
        }

        return LottoRank.parseLottoRank(sameValue); // 랭크로 변환 후 반환
    }

    /**
     * 랭킹 기록을 초기화한다.
     */
    private void initializeRanks() {
        // 모든 수를 0으로 초기화
        for (LottoRank category : LottoRank.values()) {
            ranks.put(category, 0);
        }
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
