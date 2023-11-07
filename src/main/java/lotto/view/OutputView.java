package lotto.view;

import static lotto.condition.Symbols.DELIMITER;
import static lotto.condition.Symbols.PREFIX;
import static lotto.condition.Symbols.SEPARATOR;
import static lotto.condition.Symbols.SUFFIX;
import static lotto.console.Console.println;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.condition.Count;
import lotto.condition.Reward;

public class OutputView {
    private static final String PRIZE_RESULT_FORMAT = "\n당첨 통계\n%s";
    private static final String RESULT_FORMAT = "%s (%s원) - %d개";
    private static final String PROFIT_RESULT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final NumberFormat moneyFormat = NumberFormat.getInstance();

    private OutputView() {
    }

    public static void printAllLotto(List<List<Integer>> allLotto) {
        allLotto.forEach(lottoNumbers -> {
            String eachLotto = lottoNumbers.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(DELIMITER.getSymbol() + " ", PREFIX.getSymbol(), SUFFIX.getSymbol()));
            println(eachLotto);
        });
    }

    public static void printPrizeResult(Map<Integer, Integer> prizeResult) {
        println(String.format(PRIZE_RESULT_FORMAT, SEPARATOR.getSymbol()));
        prizeResult.forEach((key, value) -> {
            Reward reward = Reward.getRewardByNumberOfMatches(key);
            if (reward != null) {
                String matchesCount = getMatchesCount(reward);
                int prizeAmount = reward.getNumberOfMatches();
                String formattedPrizeAmount = moneyFormat.format(prizeAmount);
                String result = String.format(RESULT_FORMAT, matchesCount, formattedPrizeAmount, value);
                println(result);
            }
        });
    }

    public static void printLottoProfit(double profit) {
        println(String.format(PROFIT_RESULT_FORMAT, profit));
    }

    public static String getMatchesCount(Reward reward) {
        Optional<Count> count = Arrays.stream(Count.values())
                .filter(c -> c.name().equals(reward.name()))
                .findFirst();
        return count.map(Count::getCorrectCount)
                .orElse("일치하지 않음");
    }
}
