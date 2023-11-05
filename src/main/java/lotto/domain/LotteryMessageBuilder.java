package lotto.domain;

import lotto.domain.lottery.Lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.domain.Computer.rateOfProfit;
import static lotto.domain.Computer.rewards;

public class LotteryMessageBuilder {

    private final static String JOIN_SYMBOL = " - ";
    private final static String MATCH_MESSAGE = " 일치";
    private final static String COUNT_UNIT = "개";
    private final static String BONUS_BALL_MESSAGE = "보너스 볼";
    private final static String PROFIT_MESSAGE_START = "총 수익률은 ";
    private final static String PROFIT_MESSAGE_END = "%입니다.";
    private final static String LOTTO_NUMBER_PREFIX = "[";
    private final static String LOTTO_NUMBER_SUFFIX = "]";
    private final static String DELIMITER = ", ";
    private final static String REWARD_PREFIX = " (";
    private final static String REWARD_SUFFIX = ")";
    private final static String REWARD_UNIT = "원";

    public String returnLottoList(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto :
                lottos) {
            sb.append(showLottoNumbers(lotto)).append("\n");
        }

        return sb.toString();
    }

    private String showLottoNumbers(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        String lottoNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, LOTTO_NUMBER_PREFIX, LOTTO_NUMBER_SUFFIX));

        return lottoNumbers;
    }

    private String returnRateOfProfit() {
        StringBuilder sb = new StringBuilder();
        sb.append(PROFIT_MESSAGE_START).append(rateOfProfit).append(PROFIT_MESSAGE_END);
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

    private String returnEachResult(int result, int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(matchingExplaination(result))
                .append(returnEachResultAmount(result))
                .append(JOIN_SYMBOL)
                .append(count)
                .append(COUNT_UNIT)
                .append("\n");

        return sb.toString();
    }

    private String matchingExplaination(int result) {
        StringBuilder sb = new StringBuilder();
        if (result >= 3 && result <= 5) {
            sb.append(8-result).append(COUNT_UNIT).append(MATCH_MESSAGE);
            return sb.toString();
        }
        if (result == 2) {
            sb.append(5).append(COUNT_UNIT).append(MATCH_MESSAGE)
                    .append(DELIMITER)
                    .append(BONUS_BALL_MESSAGE)
                    .append(MATCH_MESSAGE);
            return sb.toString();
        }
        sb.append(6).append(COUNT_UNIT).append(MATCH_MESSAGE);
        return sb.toString();
    }

    private String returnEachResultAmount(int result) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        sb.append(REWARD_PREFIX)
                .append(decimalFormat.format(rewards[result - 1]))
                .append(REWARD_UNIT)
                .append(REWARD_SUFFIX);
        return sb.toString();
    }

}
