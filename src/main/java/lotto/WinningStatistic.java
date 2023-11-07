package lotto;

import static lotto.Constants.LottoConstant.INIT_COUNT;
import static lotto.Constants.LottoConstant.ONE;
import static lotto.Constants.MessageConstant.STATISTIC_MESSAGE;
import static lotto.Constants.MessageConstant.THOUSANDS_SEPARATOR;
import static lotto.Constants.NumberOfLottoCorrect.*;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.Constants.NumberOfLottoCorrect;

public class WinningStatistic {

    public static final long INIT_AMOUNT = 0L;
    private final Map<NumberOfLottoCorrect, Integer> winningStatistics;

    private WinningStatistic() {
        this.winningStatistics = Stream.of(values())
            .collect(Collectors.toMap(key -> key, key -> INIT_COUNT));
    }

    public static WinningStatistic newInstance() {
        return new WinningStatistic();
    }

    public void increaseCount(NumberOfLottoCorrect numberOfLottoCorrect) {
        winningStatistics.put(numberOfLottoCorrect,
            winningStatistics.get(numberOfLottoCorrect) + ONE);
    }

    public Long getTotalWinningAmount() {
        Long totalAmount = INIT_AMOUNT;
        for (NumberOfLottoCorrect numberOfLottoCorrect : values()) {
            Integer count = winningStatistics.get(numberOfLottoCorrect);
            totalAmount += numberOfLottoCorrect.getWinningAmount() * count;
        }
        return totalAmount;
    }

    public String getStatisticMessage() {
        return
            STATISTIC_MESSAGE
                .formatted(
                    String.format(THOUSANDS_SEPARATOR, THREE_MATCHES.getWinningAmount()),
                    winningStatistics.get(THREE_MATCHES),
                    String.format(THOUSANDS_SEPARATOR, FOUR_MATCHES.getWinningAmount()),
                    winningStatistics.get(FOUR_MATCHES),
                    String.format(THOUSANDS_SEPARATOR, FIVE_MATCHES.getWinningAmount()),
                    winningStatistics.get(FIVE_MATCHES),
                    String.format(THOUSANDS_SEPARATOR, FIVE_BONUS_MATCHES.getWinningAmount()),
                    winningStatistics.get(FIVE_BONUS_MATCHES),
                    String.format(THOUSANDS_SEPARATOR, SIX_MATCHES.getWinningAmount()),
                    winningStatistics.get(SIX_MATCHES)
                );
    }
}
