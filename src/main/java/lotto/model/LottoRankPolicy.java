package lotto.model;

import java.util.List;
import lotto.enums.LottoRank;

public class LottoRankPolicy implements RankPolicy {

    //로또 번호를 확인하고 해당하는 결과값을 내보냄.
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoRankPolicy(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    @Override
    public String calculateRank(Lotto lotto) {
        int winningCount = checkLottoNumber(lotto.getNumbers());
        int bonusCount = checkBonusNumber(lotto.getNumbers());
        return checkLottoRank(winningCount, bonusCount);
    }

    private int checkLottoNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    private int checkBonusNumber(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
            .filter(number -> number == bonusNumber)
            .count();
    }

    private String checkLottoRank(int winningCount, int bonusCount) {
        if (winningCount == 3) {
            return LottoRank.FIFTH_PRIZE.name();
        }
        if (winningCount == 4) {
            return LottoRank.FOURTH_PRIZE.name();
        }
        if (winningCount == 5 && bonusCount == 1) {
            return LottoRank.SECOND_PRIZE.name();
        }
        if (winningCount == 5) {
            return LottoRank.THIRD_PRIZE.name();
        }
        if (winningCount == 6) {
            return LottoRank.FIRST_PRIZE.name();
        }
        return LottoRank.NO_PRIZE.name();
    }
}
