package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Prize;
import lotto.dto.LottoResponse;
import lotto.dto.PrizeCountResponse;

public class OutputView {
    private static final String PURCHASE_COUNT_FORMAT = "%d개를 구매했습니다.";
    private static final String LOTTO_NUMBERS_FORMAT = "[%s]";
    private static final String COMMON_WINNING_RESULT_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_WINNING_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RETURN_RATE_FORMAT = "총 수익률은 %s%%입니다.";
    private static final String WINNING_RESULT_TITLE = "당첨 통계";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String WINNING_TITLE_DASH = "-";
    private static final int WINNING_TITLE_DASH_REPEAT_COUNT = 3;

    public static void printPurchasedCount(final int purchasedCount) {
        System.out.println();
        System.out.printf(PURCHASE_COUNT_FORMAT, purchasedCount);
        System.out.println();
    }

    public static void printPurchasedLottos(List<LottoResponse> lottoResponses) {
        lottoResponses.forEach(OutputView::printPurchasedLotto);
    }

    private static void printPurchasedLotto(LottoResponse lottoResponse) {
        String joinedNumbers = lottoResponse.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));

        System.out.printf(LOTTO_NUMBERS_FORMAT, joinedNumbers);
        System.out.println();
    }

    public static void printPrizeCount(PrizeCountResponse prizeCount) {
        System.out.println();
        System.out.println(WINNING_RESULT_TITLE);
        System.out.println(WINNING_TITLE_DASH.repeat(WINNING_TITLE_DASH_REPEAT_COUNT));

        prizeCount.getPrizeCount().forEach(OutputView::printOnePrizeCount);
    }

    private static void printOnePrizeCount(Prize prize, int count) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String winningAmount = numberFormat.format(prize.getWinningAmount());

        if (prize.equals(Prize.SECOND)) {
            System.out.printf(SECOND_WINNING_RESULT_FORMAT, prize.getMatchingCount(), winningAmount, count);
            System.out.println();
            return;
        }
        System.out.printf(COMMON_WINNING_RESULT_FORMAT, prize.getMatchingCount(), winningAmount, count);
        System.out.println();
    }

    public static void printReturnRate(double returnRate) {
        System.out.println();
        System.out.printf(RETURN_RATE_FORMAT, String.format("%.1f", returnRate));
    }
}