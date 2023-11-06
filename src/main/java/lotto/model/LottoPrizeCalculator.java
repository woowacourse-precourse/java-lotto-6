package lotto.model;

import static lotto.model.LottoPrize.FIFTH_PRIZE;
import static lotto.model.LottoPrize.FIRST_PRIZE;
import static lotto.model.LottoPrize.FOURTH_PRIZE;
import static lotto.model.LottoPrize.NO_PRIZE;
import static lotto.model.LottoPrize.SECOND_PRIZE;
import static lotto.model.LottoPrize.THIRD_PRIZE;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoPrizeCalculator {

    private static final long ZERO = 0L;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    private final Lottos lottos;
    private final WinningNumbers winningNumbers;

    public LottoPrizeCalculator(final Lottos lottos, final WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public long calculateTotalPrize() {
        Map<LottoPrize, Long> lottoPrizeStatus = groupByLottoPrize();

        return lottoPrizeStatus.entrySet().stream()
                .mapToLong(entry -> multiplyNumbers(entry.getKey().getPrize(), entry.getValue()))
                .sum();
    }

    public Map<String, Long> getWinningStatistics() {
        Map<LottoPrize, Long> lottoWinningStatus = groupByLottoPrize();

        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize != LottoPrize.NO_PRIZE)
                .collect(Collectors.toMap(LottoPrize::getDescription,
                        count -> lottoWinningStatus.getOrDefault(count, ZERO),
                        (lottoPrize1, lottoPrize2) -> lottoPrize1,
                        LinkedHashMap::new
                ));
    }

    private Map<LottoPrize, Long> groupByLottoPrize() {
        return lottos.getLottos().stream()
                .collect(Collectors.groupingBy(this::getLottoPrize, Collectors.counting()));
    }

    private LottoPrize getLottoPrize(final Lotto lotto) {
        int correctCount = lotto.countCorrectNumbers(winningNumbers.getWinningNumber());

        return calculateRank(correctCount, lotto);
    }

    private LottoPrize calculateRank(final int count, final Lotto lotto) {

        return switch (count) {
            case THREE -> FIFTH_PRIZE;
            case FOUR -> FOURTH_PRIZE;
            case FIVE -> checkBonusNumber(lotto, winningNumbers.getBonusNumber());
            case SIX -> FIRST_PRIZE;
            default -> NO_PRIZE;
        };
    }

    private LottoPrize checkBonusNumber(final Lotto lotto, final int bonusNumber) {
        if (lotto.hasBonusNumber(bonusNumber)) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }

    private long multiplyNumbers(long prize, long count) {
        return prize * count;
    }
}
