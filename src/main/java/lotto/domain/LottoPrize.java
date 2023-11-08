package lotto.domain;

import static lotto.domain.constant.LottoPrizeConstant.FIRST_PRIZE_COUNT;
import static lotto.domain.constant.LottoPrizeConstant.FIFTH_PRIZE_COUNT;
import static lotto.domain.constant.LottoPrizeConstant.FOURTH_PRIZE_COUNT;
import static lotto.domain.constant.LottoPrizeConstant.SECOND_PRIZE_COUNT;
import static lotto.domain.constant.LottoPrizeConstant.THIRD_PRIZE_COUNT;

import java.util.List;

public class LottoPrize {
    private int firstRankCount;

    private int secondRankCount;

    private int thirdRankCount;

    private int fourthRankCount;

    private int fifthRankCount;

    private LottoPrize() {
        this.firstRankCount = 0;
        this.secondRankCount = 0;
        this.thirdRankCount = 0;
        this.fourthRankCount = 0;
        this.fifthRankCount = 0;
    }

    public static LottoPrize create() {
        return new LottoPrize();
    }

    public void countPrizeRank(Lottos lottos, LottoWinningNumbers lottoWinningNumbers) {
        lottos.getLottos().forEach(lotto -> countCommonNumber(lotto, lottoWinningNumbers));
    }

    public void countCommonNumber(Lotto lotto, LottoWinningNumbers lottoWinningNumbers) {
        List<Integer> winningNumbers = lottoWinningNumbers.getWinningNumbers().getNumbers();
        int bonusNumber = lottoWinningNumbers.getBonusNumber().getNumber();
        int winningRankCount = (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
        boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);
        updateRankCount(winningRankCount, hasBonusNumber);
    }

    public void updateRankCount(int winningRankCount, boolean hasBonusNumber) {
        if (winningRankCount == FIFTH_PRIZE_COUNT.getNumber()) {
            fifthRankCount++;
        }
        if (winningRankCount == FOURTH_PRIZE_COUNT.getNumber()) {
            fourthRankCount++;
        }
        if (winningRankCount == THIRD_PRIZE_COUNT.getNumber() && !hasBonusNumber) {
            thirdRankCount++;
        }
        if (winningRankCount == SECOND_PRIZE_COUNT.getNumber() && hasBonusNumber) {
            secondRankCount++;
        }
        if (winningRankCount == FIRST_PRIZE_COUNT.getNumber()) {
            firstRankCount++;
        }
    }

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int getFirstRankCount() {
        return firstRankCount;
    }

    public int getSecondRankCount() {
        return secondRankCount;
    }

    public int getThirdRankCount() {
        return thirdRankCount;
    }

    public int getFourthRankCount() {
        return fourthRankCount;
    }

    public int getFifthRankCount() {
        return fifthRankCount;
    }
}
