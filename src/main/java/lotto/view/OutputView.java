package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.LottoRank;
import lotto.dto.LottoResultDto;
import lotto.dto.LottosDto;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private static final String OUTPUT_BUY_QUANTITY_FORMAT = "%n%d개를 구매했습니다.%n";
    private static final String OUTPUT_LOTTO_RESULT_FORMAT = "%s개 일치 (%,d원) - %d개%n";
    private static final String OUTPUT_BONUS_LOTTO_RESULT_FORMAT = "%s개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String OUTPUT_TOTAL_RETURN = "총 수익률은 %,.1f%%입니다.%n";
    private static final String OUTPUT_STATISTICS_WINNING = "%n당첨 통계%n";
    private static final String OUTPUT_STATISTICS_WINNING_DIVIDER = "---";


    public static void printQuantity(int quantity) {
        System.out.printf(OUTPUT_BUY_QUANTITY_FORMAT, quantity);
    }

    public static void printLottos(LottosDto dto) {
        dto.getLotto().forEach(System.out::println);
    }

    public static void printLottoResult(LottoResultDto dto) {
        System.out.printf(OUTPUT_STATISTICS_WINNING);
        System.out.println(OUTPUT_STATISTICS_WINNING_DIVIDER);

        dto.getResult().forEach(OutputView::printLottoResultByRank);
    }

    private static void printLottoResultByRank(LottoRank rank, Integer count) {
        System.out.printf(getFormat(rank), rank.getMatchCount(), rank.getPrizeAmount(), count);
    }

    private static String getFormat(LottoRank rank) {
        if (rank.isContainBonusRank()) {
            return OUTPUT_BONUS_LOTTO_RESULT_FORMAT;
        }
        return OUTPUT_LOTTO_RESULT_FORMAT;
    }


}
