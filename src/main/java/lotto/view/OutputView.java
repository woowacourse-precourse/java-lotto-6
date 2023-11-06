package lotto.view;

import java.util.EnumMap;

import lotto.domain.Rank;
import lotto.dto.LottoNumbersDto;
import lotto.converter.PrintFormatConverter;

public final class OutputView {

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

    public static void printPurchasedLottoCount(final int purchasedCount) {
        System.out.printf(addLineSeparator(PURCHASED_LOTTO_COUNT_GUIDE), purchasedCount);
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
        printEachRankResult(rankResult);
    }

    private static void printEachRankResult(final EnumMap<Rank, Integer> rankResult) {
        rankResult.forEach((rank, rankingCount) -> {
            int matchingCount = rank.matchingCount();
            String reward = applyRewardFormat(rank);
            if (rank.isSecond(rank)) {
                printSecondRankResult(rankingCount, matchingCount, reward);
            }
            if (!rank.isSecond(rank)) {
                printRankResult(rankingCount, matchingCount, reward);
            }
        });
    }

    private static void printSecondRankResult(final int rankingCount, final int matchingCount, final String reward) {
        System.out.printf(addLineSeparatorInSuffix(SECOND_RANK_RESULT_GUIDE), matchingCount, reward, rankingCount);
    }

    private static void printRankResult(final int rankingCount, final int matchingCount, final String reward) {
        System.out.printf(addLineSeparatorInSuffix(RANK_RESULT_GUIDE), matchingCount, reward, rankingCount);
    }

    private static String applyRewardFormat(final Rank rank) {
        return PrintFormatConverter.convertToRewardFormat(rank.reward());
    }

    public static void printTotalYield(final double yield) {
        String formattedYield = PrintFormatConverter.convertToYieldFormat(yield);
        System.out.printf(TOTAL_YIELD_GUIDE, formattedYield);
    }

    private static String addLineSeparator(final String guide) {
        return String.join("", System.lineSeparator(), guide);
    }

    private static String addLineSeparatorInSuffix(final String guide) {
        return String.join("", guide, System.lineSeparator());
    }

}
