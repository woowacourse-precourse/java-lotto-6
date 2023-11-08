package lotto.domain;

import lotto.domain.lottery.Lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.Computer.rateOfProfit;
import static lotto.domain.Computer.rewards;
import static lotto.domain.constants.LotteryMessageConstant.*;

public class LotteryMessageBuilder {
    private static final String REWARD_FORMAT = "###,###";

    public String returnLottoList(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto :
                lottos) {
            sb.append(showLottoNumbers(lotto)).append("\n");
        }

        return sb.toString();
    }

    public String returnWinningLottoList(Map<Integer, Integer> winningStats) {
        StringBuilder sb = new StringBuilder();
        for (int result = 5; result >= 1; result--) {
            sb.append(returnEachResult(result, winningStats.get(result)));
        }
        sb.append(returnRateOfProfit());
        return sb.toString();
    }

    private String showLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();

        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER.getMessage(), LOTTO_NUMBER_PREFIX.getMessage(), LOTTO_NUMBER_SUFFIX.getMessage()));
    }

    private String returnRateOfProfit() {
        return PROFIT_MESSAGE_START.getMessage() + rateOfProfit + PROFIT_MESSAGE_END.getMessage();
    }

    private String returnEachResult(int result, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(matchingExplaination(result))
                .append(returnEachResultAmount(result))
                .append(JOIN_SYMBOL.getMessage())
                .append(count)
                .append(COUNT_UNIT.getMessage())
                .append("\n");

        return sb.toString();
    }

    private String matchingExplaination(int result) {
        StringBuilder sb = new StringBuilder();
        if (result >= 3 && result <= 5) {
            sb.append(8-result).append(COUNT_UNIT.getMessage()).append(MATCH_MESSAGE.getMessage());
            return sb.toString();
        }
        if (result == 2) {
            sb.append(5).append(COUNT_UNIT.getMessage()).append(MATCH_MESSAGE.getMessage())
                    .append(DELIMITER.getMessage())
                    .append(BONUS_BALL_MESSAGE.getMessage())
                    .append(MATCH_MESSAGE.getMessage());
            return sb.toString();
        }
        sb.append(6).append(COUNT_UNIT.getMessage()).append(MATCH_MESSAGE.getMessage());
        return sb.toString();
    }

    private String returnEachResultAmount(int result) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat(REWARD_FORMAT);
        sb.append(REWARD_PREFIX.getMessage())
                .append(decimalFormat.format(rewards[result - 1]))
                .append(REWARD_UNIT.getMessage())
                .append(REWARD_SUFFIX.getMessage());
        return sb.toString();
    }

}
