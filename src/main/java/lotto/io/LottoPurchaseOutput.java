package lotto.io;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import lotto.data.Lotto;
import lotto.data.LottoPrize;
import lotto.domain.LottoResult;

public enum LottoPurchaseOutput {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
    private String message;
    private final static String LOTTO_PURCHASE_MESSAGE = "%d개를 구매했습니다.\n";
    private final static String WINNING_STATISTICS_HEADER_MESSAGE = "당첨 통계\n---------\n";
    private final static String WINNING_STATISTICS_BODY_MESSAGE = "%s - %s개\n";
    private final static String WINNING_STATISTICS_FOOTER_MESSAGE = "총 수익률은 %s%%입니다.";
    private final static List<LottoPrize> PRINT_LOTTO_PRIZE_ORDER = List.of(
            LottoPrize.FIFTH
            , LottoPrize.FOURTH
            , LottoPrize.THIRD
            , LottoPrize.SECOND
            , LottoPrize.FIRST);
    private final static int DIGITS_AFTER_DECIMAL_POINT = 1;

    LottoPurchaseOutput(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.printf(LOTTO_PURCHASE_MESSAGE, lottos.size());
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto).append("\n"));
        System.out.println(sb);
    }

    public static void printWinningStatistics(LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        HashMap<LottoPrize, BigDecimal> result = lottoResult.getLottoRank();
        sb.append(WINNING_STATISTICS_HEADER_MESSAGE);

        for (LottoPrize lottoPrize : PRINT_LOTTO_PRIZE_ORDER) {
            BigDecimal count = result.get(lottoPrize);
            sb.append(getWinningStatisticsBody(lottoPrize.getMessage(), count));
        }

        BigDecimal profitPercent = lottoResult.getProfitPercent()
                .setScale(DIGITS_AFTER_DECIMAL_POINT, RoundingMode.DOWN);
        sb.append(String.format(WINNING_STATISTICS_FOOTER_MESSAGE, profitPercent));
        System.out.println(sb);
    }

    private static String getWinningStatisticsBody(String message, BigDecimal count) {
        return String.format(WINNING_STATISTICS_BODY_MESSAGE, message, count);
    }
}
