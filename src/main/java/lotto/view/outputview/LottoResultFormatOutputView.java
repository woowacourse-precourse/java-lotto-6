package lotto.view.outputview;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lottoresult.LottoResultStatus;

public class LottoResultFormatOutputView {
    private static final String SECOND_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String RESULT_FORMAT = "%d개 일치 (%s원) - %d개\n";

    public static void printLottoResultFormat(LottoCheckResult lottoCheckResult) {
        Map<LottoResultStatus, Integer> result = lottoCheckResult.getResult();

        for (Map.Entry<LottoResultStatus, Integer> entry : result.entrySet()) {
            LottoResultStatus resultStatus = entry.getKey();
            String prize = convertToKoreanCurrency(resultStatus);
            Integer resultCount = entry.getValue();
            long matchCount = resultStatus.getMatchCount();

            if (isSecond(resultStatus)) {
                System.out.printf(SECOND_RESULT_FORMAT, matchCount, prize, resultCount);
            } else if (isOverFifth(resultStatus)) {
                System.out.printf(RESULT_FORMAT, matchCount, prize, resultCount);
            }
        }
    }

    private static boolean isOverFifth(LottoResultStatus resultStatus) {
        return resultStatus != LottoResultStatus.FAIL;
    }

    private static boolean isSecond(LottoResultStatus resultStatus) {
        return resultStatus == LottoResultStatus.FIVE_MATCH_WITH_BONUS;
    }

    private static String convertToKoreanCurrency(LottoResultStatus status) {
        Locale locale = new Locale("ko", "KR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        int prize = status.getPrize();

        return formatter.format(prize).substring(1);
    }
}
