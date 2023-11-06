package lotto.view;

import java.util.Comparator;
import java.util.List;

public final class LottoOutputView {
    private final static String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.";
    private final static String WINNING_LOTTO_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요";
    private final static String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private final static String[] RANK_MESSAGE = {
            "3개 일치 (5,000원) - %d개",
            "4개 일치 (50,000원) - %d개",
            "5개 일치 (1,500,000원) - %d개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
            "6개 일치 (2,000,000,000원) - %d개"
    };
    private final static String GAIN_RATIO_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private LottoOutputView() {
    }

    public static void printPurchasePriceMessage() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
    }

    public static void printLottoCount(int lottoCount) {
        String lottCountMessage = String.format(LOTTO_COUNT_MESSAGE, lottoCount);
        System.out.println(lottCountMessage);
    }

    public static void printLottoNumbers(List<List<Integer>> numbers) {
        for (List<Integer> number : numbers) {
            number.sort(Comparator.naturalOrder());
            System.out.println(number);
        }
    }

    public static void printWinningLottoNumbersMessage() {
        System.out.println(WINNING_LOTTO_NUMBER_MESSAGE);
    }

    public static void printBonusNumberMessage() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static void printWinningStatistics(List<Long> countByRank, double gainRatio) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        printRankResult(countByRank);
        printGainRatio(gainRatio);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private static void printRankResult(List<Long> countByRank) {
        for (int i = 0; i < countByRank.size(); i++) {
            String rankMessage = String.format(RANK_MESSAGE[i], countByRank.get(i));
            System.out.println(rankMessage);
        }
    }

    private static void printGainRatio(double gainRatio) {
        String gainRatioMessage = String.format(GAIN_RATIO_MESSAGE, gainRatio);
        System.out.println(gainRatioMessage);
    }

}
