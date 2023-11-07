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
}
