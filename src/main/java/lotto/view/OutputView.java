package lotto.view;

import lotto.domain.RankInfo;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.dto.YieldResult;
import lotto.util.message.LottoRankingMessage;

import java.util.Arrays;
import java.util.List;

public class OutputView {

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printPurchaseResult(List<PurchaseResult> purchaseResults) {
        System.out.printf(Constants.INPUT_MONEY.message, purchaseResults.size());
        purchaseResults
                .forEach(result -> System.out.println(result.lottoNumbers()));
    }

    public void printLottoGameResult(LottoGameResult lottoGameResult) {
        Arrays.stream(RankInfo.values())
                .filter(rankInfo -> rankInfo != RankInfo.NONE)
                .forEach(rankInfo -> {
                    Integer count = lottoGameResult.gameResult().getOrDefault(rankInfo, 0);
                    String lottoRankingMessage = LottoRankingMessage.findLottoRankingMessage(rankInfo, count);
                    System.out.println(lottoRankingMessage);
                });
    }

    public void printYield(YieldResult yieldResult) {
        System.out.println(Constants.SEPARATOR.message);
        System.out.println(Constants.WINNING_STATS_HEADER.message);
        System.out.printf(Constants.TOTAL_YIELD.message, yieldResult.yield());
    }

    private enum Constants {
        INPUT_MONEY("%d개를 구매했습니다.%n"),
        SEPARATOR("---"),
        WINNING_STATS_HEADER("당첨 통계"),
        TOTAL_YIELD("총 수익률은 %s%%입니다.");


        private final String message;

        Constants(String message) {
            this.message = message;
        }
    }
}
