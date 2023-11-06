package view;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.Rank;

public class Output {
    private static final String PURCHASE_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_SEPARATOR = "[%s]";
    private static final String LOTTO_NUMBERS_JOIN_SEPARATOR = ", ";
    private static final String LINE_BREAK = "\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String WINNING_STATISTICS_SEPARATOR = "---";
    private static final String PRIZE_DESCRIPTION = "%d개 일치 (%s원) - %d개";
    public static final String SECOND_PRIZE_DESCRIPTION = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public static void getLottoNumbers(List<Lotto> lottoList) {
        System.out.printf(LINE_BREAK + PURCHASE_AMOUNT_MESSAGE + LINE_BREAK, lottoList.size());
        lottoList.forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            String lottoNumbers = formatLottoNumbers(numbers);
            System.out.printf(LOTTO_NUMBERS_SEPARATOR + LINE_BREAK, lottoNumbers);
        });
    }

    private static String formatLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBERS_JOIN_SEPARATOR));
    }

    public static void printLottoGameResult() {
        System.out.println(LINE_BREAK + WINNING_STATISTICS_MESSAGE);
        System.out.println(WINNING_STATISTICS_SEPARATOR);
    }

    public static void handlePrizeDescription(Rank rank, long rankCount, long prizeAmount) {

        if (rank.equals(Rank.SECOND)) {
            printPrizeDescription(rank, rankCount, prizeAmount, SECOND_PRIZE_DESCRIPTION);
        } else if (!rank.equals(Rank.FAIL)) {
            printPrizeDescription(rank, rankCount, prizeAmount, PRIZE_DESCRIPTION);
        }
    }

    private static void printPrizeDescription(Rank rank, long rankCount, long prizeAmount, String description) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        System.out.printf(description + LINE_BREAK, rank.getMatchCount(),
                numberFormat.format(prizeAmount), rankCount);
    }
}
