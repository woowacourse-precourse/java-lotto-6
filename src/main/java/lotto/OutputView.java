package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String MESSAGE_PURCHASE_COMPLETED = "개를 구매했습니다.";
    private static final String MESSAGE_WINNING_STATISTICS = "당첨 통계";
    private static final String MESSAGE_HYPHENS = "---";
    private static final String MESSAGE_FORMAT_RANK_5 = "3개 일치 (%,d원) - %d개%n";
    private static final String MESSAGE_FORMAT_RANK_4 = "4개 일치 (%,d원) - %d개%n";
    private static final String MESSAGE_FORMAT_RANK_3 = "5개 일치 (%,d원) - %d개%n";
    private static final String MESSAGE_FORMAT_RANK_2 = "5개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    private static final String MESSAGE_FORMAT_RANK_1 = "6개 일치 (%,d원) - %d개%n";
    private static final String MESSAGE_FORMAT_GROSS_PROFIT_RATE = "총 수익률은 %,.1F%%입니다.%n";

    public void writePurchaseDetails(List<Lotto> lottery) {
        System.out.println(lottery.size() + MESSAGE_PURCHASE_COMPLETED);
        for (Lotto lotto : lottery) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void writeLottoResult(LottoWinningResultSummary lottoWinningResultSummary) {
        LottoResult lottoResult = lottoWinningResultSummary.getLottoResult();
        double grossProfitRate = lottoWinningResultSummary.getGrossProfitRate();
        Map<LottoRank, Integer> rankResult = lottoResult.getRankResult();
        final Map<LottoRank, String> resultMessage = new LinkedHashMap<>();

        System.out.println(MESSAGE_WINNING_STATISTICS);
        System.out.println(MESSAGE_HYPHENS);
        resultMessage.put(LottoRank.RANK_5, MESSAGE_FORMAT_RANK_5);
        resultMessage.put(LottoRank.RANK_4, MESSAGE_FORMAT_RANK_4);
        resultMessage.put(LottoRank.RANK_3, MESSAGE_FORMAT_RANK_3);
        resultMessage.put(LottoRank.RANK_2, MESSAGE_FORMAT_RANK_2);
        resultMessage.put(LottoRank.RANK_1, MESSAGE_FORMAT_RANK_1);

        for (Map.Entry<LottoRank, String> entry : resultMessage.entrySet()) {
            LottoRank rank =  entry.getKey();
            String message = entry.getValue();
            int count = rankResult.getOrDefault(rank, 0);
            System.out.printf(message, rank.getPrize(), count);
        }
        System.out.printf(MESSAGE_FORMAT_GROSS_PROFIT_RATE, grossProfitRate);
    }
}
