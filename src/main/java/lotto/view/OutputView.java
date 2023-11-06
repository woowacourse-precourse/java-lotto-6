package lotto.view;

import lotto.domain.RankInfo;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;
import lotto.util.message.LottoRankingMessage;

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
        System.out.println("당첨 통계");
        System.out.println("---");

        for (RankInfo rankInfo : RankInfo.values()) {
            int count = lottoGameResult.gameResult().getOrDefault(rankInfo, 0);
            String lottoRankingMessage = LottoRankingMessage.findLottoRankingMessage(rankInfo, count);
            System.out.println(lottoRankingMessage);
        }
    }


    private enum Constants {
        INPUT_MONEY("%d개를 구매했습니다.%n"),
        PICK_LOTTO_TICKET_NUMBER("당첨 번호를 입력해주세요.");

        private final String message;

        Constants(String message) {
            this.message = message;
        }
    }
}
