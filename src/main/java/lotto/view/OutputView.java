package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrizeBreakdown;
import lotto.domain.LottoRank;
import lotto.domain.RateOfReturn;
import lotto.util.LottoGuideMessage;

public class OutputView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMessage(LottoGuideMessage lottoGuideMessage) {
        System.out.println(lottoGuideMessage.getMessage());
    }

    public void showSeperateLine() {
        System.out.println();
    }

    public void showIssueLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(formatPurchaseCountInfo(lottoTickets.size()));
        lottoTickets.forEach(System.out::println);
        System.out.println();
    }

    private String formatPurchaseCountInfo(int purchaseCount) {
        //포맷 패턴: "{purchaseCount}개를 구매했습니다."
        //예시 출력: "8개를 구매했습니다."
        return String.format(LottoGuideMessage.PURCHASE_COUNT_INFO_FORMAT.getMessage(), purchaseCount);
    }

    public void showWinningStatistics(LottoPrizeBreakdown result, RateOfReturn rateOfReturn) {
        Map<LottoRank, Integer> report = result.getReport();

        System.out.println(LottoGuideMessage.WINNING_STATISTICS.getMessage());
        System.out.println("---");
        for (LottoRank rank : LottoRank.values()) {
            System.out.println(formatPrizeDescription(rank, report.getOrDefault(rank, 0)));
        }
        System.out.println(formatRateOfReturn(rateOfReturn));
        System.out.println();
    }

    private String formatPrizeDescription(LottoRank rank, int winCount) {
        //포맷 패턴: "{description} ({prizeMoney}원) - {winCount}개"
        //예시 출력: "3개 일치 (5,000원) - 1개"
        String prizeFormat = LottoGuideMessage.PRIZE_DESCRIPTION_FORMAT.getMessage();
        String prizeMoney = formatMoney(rank.getPrizeMoney());
        String description = rank.getDescription();
        return String.format(prizeFormat, description, prizeMoney, winCount);
    }

    private String formatMoney(int amount) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(amount);
    }

    private String formatRateOfReturn(RateOfReturn rateOfReturn) {
        //포맷 패턴: "총 수익률은 {rateOfReturn}%입니다."
        //예시 출력: "총 수익률은 62.5%입니다."
        String rateOfReturnFormat = LottoGuideMessage.RATE_OF_RETURN_FORMAT.getMessage();
        String returnOfRate = formatRate(rateOfReturn.value());
        return String.format(rateOfReturnFormat, returnOfRate);
    }

    private String formatRate(BigDecimal rateOfReturn) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###.0");
        return decimalFormat.format(rateOfReturn);
    }
}
