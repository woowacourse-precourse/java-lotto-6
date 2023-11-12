package lotto.domain.lotto_policy;

import static lotto.domain.lotto_prize.FixedLottoPrizeStandard.FIVE_NUMBER_WITH_BONUS;
import static lotto.domain.lotto_prize.FixedLottoPrizeStandard.values;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto_prize.FixedLottoPrizeStandard;

public class FixedLottoWinningPolicy {
    private final Integer bonusNumber;
    private final List<FixedLottoPrizeStandard> fixedLottoPrizeStandards;

    public FixedLottoWinningPolicy(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
        fixedLottoPrizeStandards = Arrays.stream(values()).toList();
    }

    public List<FixedLottoPrizeStandard> getWinningResult(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        return fixedLottoPrizeStandards.stream()
                .filter(prizeStandard -> isWinning(prizeStandard, lottoNumbers, winningNumbers))
                .toList();
    }

    private Boolean isWinning(FixedLottoPrizeStandard prizeStandard, List<Integer> lottoNumbers, List<Integer> winningNumbers){
        Long matchCount = lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();

        if(prizeStandard.equals(FIVE_NUMBER_WITH_BONUS)
                && matchCount.equals(FIVE_NUMBER_WITH_BONUS.getMatchCount())
                && lottoNumbers.contains(bonusNumber)){
            return true;
        }

        return matchCount >= prizeStandard.getMatchCount();
    }

    public List<FixedLottoPrizeStandard> getFixedLottoPrizeStandards() {
        return fixedLottoPrizeStandards;
    }
}
