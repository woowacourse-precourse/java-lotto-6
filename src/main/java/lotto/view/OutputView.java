package lotto.view;

import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.Map.Entry;

import lotto.domain.Payment;
import lotto.domain.Rank;
import lotto.dto.LottoNumbersDto;

public class OutputView {

    private static final String PAYMENT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_LOTTO_COUNT_GUIDE = "%d개를 구매했습니다.";
    private static final String WINNING_LOTTO_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_GUIDE = "당첨 통계";
    private static final String LINE_SEPARATOR = "---";
    private static final String RANK_RESULT_GUIDE = "%d개 일치 (%s) - %d개";
    private static final String SECOND_RANK_RESULT_GUIDE = "%d개 일치, 보너스 볼 일치 (%s) - %d개";
    private static final String TOTAL_YIELD_GUIDE = "총 수익률은 %s%%입니다.";

    private OutputView() {
    }

    public static void printPaymentGuide() {
        System.out.println(PAYMENT_GUIDE);
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printPurchasedLottoCount(Payment payment) {
        System.out.printf(addLineSeparator(PURCHASED_LOTTO_COUNT_GUIDE), payment.calculatePurchasedLottoCount());
    }

    public static void printIssuedLottosNumbers(final LottoNumbersDto lottoNumbersDto) {
        System.out.println();
        lottoNumbersDto.getLottosNumbers()
                .forEach(System.out::println);
    }

    public static void printWinningLottoNumbersGuide() {
        System.out.println(addLineSeparator(WINNING_LOTTO_NUMBERS_GUIDE));
    }

    public static void printBonusNumberGuide() {
        System.out.println(addLineSeparator(BONUS_NUMBER_GUIDE));
    }

    public static void printWinningStatistics(final EnumMap<Rank, Integer> rankResult) {
        System.out.println(addLineSeparator(WINNING_STATISTICS_GUIDE));
        System.out.println(LINE_SEPARATOR);
        for (Entry<Rank, Integer> entry : rankResult.entrySet()) {
            Rank rank = entry.getKey();
            int matchingCount = rank.matchingCount();
            DecimalFormat decimalFormat = new DecimalFormat("#,###원");
            String reward = decimalFormat.format(rank.reward());
            int rankingCount = entry.getValue();
            if (rank.equals(Rank.SECOND)) {
                System.out.printf(addLineSeparatorInSuffix(SECOND_RANK_RESULT_GUIDE), matchingCount, reward,
                        rankingCount);
                continue;
            }
            System.out.printf(addLineSeparatorInSuffix(RANK_RESULT_GUIDE), matchingCount, reward, rankingCount);
        }
    }

    public static void printTotalYield(final double yield) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        String format = decimalFormat.format(yield);
        System.out.printf(TOTAL_YIELD_GUIDE, format);
    }

    private static String addLineSeparator(final String guide) {
        return String.join("", System.lineSeparator(), guide);
    }

    private static String addLineSeparatorInSuffix(final String guide) {
        return String.join("", guide, System.lineSeparator());
    }

}
