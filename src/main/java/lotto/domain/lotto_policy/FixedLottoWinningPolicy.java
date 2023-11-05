package lotto.domain.lotto_policy;

import java.util.List;
import lotto.domain.prize_calculator.PrizeCalculator;

public class FixedLottoWinningPolicy implements LottoWinningPolicy {
    private final PrizeCalculator prizeCalculator;

    public FixedLottoWinningPolicy(PrizeCalculator prizeCalculator) {
        this.prizeCalculator = prizeCalculator;
    }

    @Override
    public Integer getWinningPrize(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Long matchCount = getMatchCount(lottoNumbers, winningNumbers);
        return getPrize(matchCount);
    }

    private Long getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers){
        return lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private Integer getPrize(Long matchCount){
        return prizeCalculator.calculatePrize(matchCount);
    }
}
