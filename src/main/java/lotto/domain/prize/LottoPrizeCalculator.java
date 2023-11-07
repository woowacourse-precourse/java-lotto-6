package lotto.domain.prize;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningNumbers;
import lotto.domain.result.LottoPrizeResult;

public class LottoPrizeCalculator {

    public LottoPrizeCalculator() {
    }

    public LottoPrizeResult calculatePrize(LottoWinningNumbers winningNumbers, LottoTickets tickets) {
        Map<LottoPrizeType, Integer> countByType = new HashMap<>();

        tickets.getTickets()
                .forEach(lotto -> {
                    Optional<LottoPrizeType> type = calculatePrize(winningNumbers, lotto);
                    type.ifPresent(lottoPrizeType -> countByType.put(
                            lottoPrizeType,
                            countByType.getOrDefault(lottoPrizeType, 0) + 1)
                    );
                });

        return new LottoPrizeResult(countByType);
    }

    public Optional<LottoPrizeType> calculatePrize(LottoWinningNumbers winningNumbers, Lotto lotto) {
        return LottoPrizeType.toPrizeType(
                winningNumbers.calculateWinningNumberCount(lotto),
                winningNumbers.matchesBonusNumber(lotto)
        );
    }

}
