package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Rank;
import lotto.dto.LottoDto;
import lotto.dto.PurchaseLottoDto;
import lotto.dto.WinningStatisticsDto;

public class OutputView {
    private static final String PURCHASED_MESSAGE_FORM = "%n%d개를 구매했습니다.%n";
    private static final String PURCHASE_LOTTO_FORM_DELIMITER = " \n";

    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String MATCH_COUNT_FORM = "%s - %d개%n";
    private static final String TOTAL_STATISTICS_FORM = "총 수익률은 %s%%입니다.";
    private static final String MONEY_COMMA_FORMAT = "###,##0.0";

    public void printPurchaseLotto(PurchaseLottoDto purchaseLottoDto) {
        System.out.printf(PURCHASED_MESSAGE_FORM, purchaseLottoDto.size());
        String purchaseLottoResultForm = makePurchaseLottoResultForm(purchaseLottoDto);
        System.out.println(purchaseLottoResultForm);
    }

    private String makePurchaseLottoResultForm(PurchaseLottoDto purchaseLottoDto) {
        List<String> purchaseLottoResults = purchaseLottoDto.getTotalPurchaseLotto()
                .stream()
                .map(LottoDto::toString)
                .toList();

        return String.join(PURCHASE_LOTTO_FORM_DELIMITER, purchaseLottoResults);
    }

    public void printWinningStatistics(WinningStatisticsDto winningStatisticsDto) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        EnumMap<Rank, Integer> eachRankCounts = winningStatisticsDto.getEachRankCounts();
        for (Rank rank : eachRankCounts.keySet()) {
            if (rank == Rank.NONE) {
                break;
            }
            System.out.printf(MATCH_COUNT_FORM, rank.getPrizeMessage(), eachRankCounts.get(rank));
        }
        System.out.printf(TOTAL_STATISTICS_FORM, convertMoneyCommaForm(winningStatisticsDto.getYieldRate()));
    }

    private String convertMoneyCommaForm(BigDecimal yield) {
        DecimalFormat decimalFormat = new DecimalFormat(MONEY_COMMA_FORMAT);
        return decimalFormat.format(yield.doubleValue());
    }
}
