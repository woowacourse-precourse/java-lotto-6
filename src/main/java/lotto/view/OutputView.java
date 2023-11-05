package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {
    public static final String PURCHASE_NUMBER_FORMAT = "개를 구매했습니다.";
    public static final String WINNING_STATISTIC_FORMAT = "당첨 통계\n---";
    public static final String OPEN_BRACKET = "[";
    public static final String CLOSE_BRACKET = "]";
    public static final String MONEY_FORMAT = ",###";

    public static void printTotalLottoNumber(int totalLottoNumber) {
        System.out.println(totalLottoNumber + PURCHASE_NUMBER_FORMAT);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(makeLottoOutput(lotto)));
    }

    public static void printTotalEarningsRate(String earningRate) {
        System.out.printf("총 수익률은 %s%%입니다.", earningRate);
    }

    public static void printWinningStatistic(Map<Rank, Integer> result) {
        System.out.println(WINNING_STATISTIC_FORMAT);

        result.remove(Rank.LOSING_TICKET);
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_FORMAT);
        result.forEach((key, value) -> makeWinningStatisticOutput(key, value, stringBuilder, decimalFormat));

        System.out.print(stringBuilder);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    private static void makeWinningStatisticOutput(
            Rank rank,
            int winningCount,
            StringBuilder stringBuilder,
            DecimalFormat decimalFormat
    ) {
        stringBuilder.append(String.format("%d개 일치", rank.getMatchingCount()));

        if (rank.isHasBonusNumber()) {
            stringBuilder.append(", 보너스 볼 일치");
        }

        stringBuilder.append(String.format(" (%s원) - ", decimalFormat.format(rank.getPrizeMoney())));

        stringBuilder.append(String.format("%d개\n", winningCount));
    }

    private static String makeLottoOutput(Lotto lotto) {
        List<Integer> sortedLottoNumbers = getSortedIntegerList(lotto.getNumbers());
        List<String> lottoNumbers = convertIntegersToStrings(sortedLottoNumbers);
        return OPEN_BRACKET + String.join(", ", lottoNumbers) + CLOSE_BRACKET;
    }

    private static List<String> convertIntegersToStrings(List<Integer> integers) {
        return integers.stream().map(integer -> Integer.toString(integer)).toList();
    }

    private static List<Integer> getSortedIntegerList(List<Integer> integers) {
        return integers.stream().sorted().toList();
    }
}
