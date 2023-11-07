package lotto.global.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.LottoResultManager;
import lotto.global.constant.ConsoleType;
import lotto.global.constant.WinningType;

public class OutputView {

    private static final String PERCENT = "%";

    private OutputView() {
    }

    public static void commonOutputLine(String output) {
        System.out.println(output);
    }

    public static void outputStatistics(double rateOfReturn, LottoResultManager lottoResultManager) {
        System.out.println(ConsoleType.OUTPUT_STATISTICS.getComment());
        Map<WinningType, Integer> statistics = lottoResultManager.getStatistics().getStatistics();
        System.out.println(ConsoleType.THREE_MATCH.getComment(statistics.get(WinningType.FIFTH)));
        System.out.println(ConsoleType.FOUR_MATCH.getComment(statistics.get(WinningType.FOURTH)));
        System.out.println(ConsoleType.FIVE_MATCH.getComment(statistics.get(WinningType.THIRD)));
        System.out.println(ConsoleType.FIVE_AND_BONUS_MATCH.getComment(statistics.get(WinningType.SECOND)));
        System.out.println(ConsoleType.ALL_MATCH.getComment(statistics.get(WinningType.FIRST)));
        BigDecimal decimalRateOfReturn = new BigDecimal(rateOfReturn).setScale(1, RoundingMode.HALF_UP);
        System.out.println(ConsoleType.OUTPUT_RATE_OF_RETURN.getComment(decimalRateOfReturn.toPlainString() + PERCENT));
    }

    public static void outputLottoNumbers(List<LottoResult> lottoResults) {
        lottoResults.forEach(System.out::println);
        System.out.println(ConsoleType.EMPTY.getComment());
    }
}
