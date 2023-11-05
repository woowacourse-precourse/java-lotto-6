package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoMatch;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final int RESET_LENGTH = 0;
    private static final String PURCHASE_INPUT_GUIDE = "구입 금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE = "\n" + "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_INFO = "당첨 통계";
    private static final String THREE_DASHES = "---";
    private static final String EMPTY_MESSAGE = "";
    private static final String BONUS_BALL_MATCH_MESSAGE = ", 보너스 볼 일치";
    private static final String LOTTO_MATCH_FORMAT = "%d개 일치%s (%,d원) - %d개";
    private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void displayPurchaseGuide() {
        System.out.println(PURCHASE_INPUT_GUIDE);
    }

    public static void displayLottoCount(final int lottoCount) {
        System.out.println("\n" + lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void displayLottoNumbers(final List<Lotto> lottoList) {
        stringBuilder.append(lottoList.stream()
                .map(lotto -> lotto.getNumbers() + "\n")
                .collect(Collectors.joining()));
        System.out.println(stringBuilder);
        stringBuilder.setLength(RESET_LENGTH);
    }

    public static void displayWinningNumberGuide() {
        System.out.println(WINNING_NUMBER_INPUT_GUIDE);
    }

    public static void displayBonusNumberGuide() {
        System.out.println(BONUS_NUMBER_INPUT_GUIDE);
    }

    public static void displayWinningStatisticsGuide() {
        stringBuilder.append("\n")
                .append(WINNING_STATISTICS_INFO)
                .append("\n")
                .append(THREE_DASHES)
                .append("\n");
    }

    public static void displayWinningStatistics(final List<LottoMatch> winningResults) {
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            if (lottoMatch == LottoMatch.NOTHING_MATCH) {
                continue;
            }
            String bonusBallMessage = determineBonusBallMessage(lottoMatch);
            long matchCount = countMatch(winningResults, lottoMatch);

            stringBuilder.append(String.format(LOTTO_MATCH_FORMAT,
                    lottoMatch.getMatching(),
                    bonusBallMessage,
                    lottoMatch.getAmount(),
                    matchCount)).append("\n");
        }
    }

    private static String determineBonusBallMessage(LottoMatch lottoMatch) {
        if (lottoMatch == LottoMatch.FIVE_AND_BONUS_MATCH) {
            return BONUS_BALL_MATCH_MESSAGE;
        }
        return EMPTY_MESSAGE;
    }

    private static long countMatch(List<LottoMatch> winningResults, LottoMatch lottoMatch) {
        return winningResults.stream()
                .filter(match -> match == lottoMatch)
                .count();
    }

    public static void displayYield(final double yield) {
        stringBuilder.append(String.format(YIELD_FORMAT, yield));
        System.out.print(stringBuilder);
    }

    public static void displayExceptionMessage(final String message) {
        System.out.println(message);
    }
}
