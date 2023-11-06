package lotto.view;

import static lotto.condition.Symbols.DELIMITER;
import static lotto.condition.Symbols.PREFIX;
import static lotto.condition.Symbols.SEPARATOR;
import static lotto.condition.Symbols.SUFFIX;
import static lotto.console.Console.println;

import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.condition.Reward;

public class OutputView {
    private static final String PRIZE_RESULT_FORMAT = "\n당첨 통계\n%s";
    private static final String RESULT_FORMAT = "%s (%s원) - %d개";
    private static final String PROFIT_RESULT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final NumberFormat moneyFormat = NumberFormat.getInstance();


    private OutputView() {
    }

    public static void printAllLotto(List<List<Integer>> allLotto) {
        allLotto.stream().map(list -> list.stream().map(Object::toString)
                        .collect(Collectors.joining(DELIMITER.getSymbol() + " ", PREFIX.getSymbol(), SUFFIX.getSymbol())))
                .forEach(System.out::println);
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

    private static String getMatchesCount(Reward reward) {
        return switch (reward) {
            case THREE -> "3개 일치";
            case FOUR -> "4개 일치";
            case FIVE -> "5개 일치";
            case FIVE_AND_BONUS -> "5개 일치, 보너스 볼 일치";
            case SIX -> "6개 일치";
        };
    }
}
