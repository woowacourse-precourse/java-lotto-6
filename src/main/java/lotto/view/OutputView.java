package lotto.view;

import lotto.domain.RankInfo;
import lotto.dto.LottoGameResult;
import lotto.dto.PurchaseResult;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

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

        NumberFormat formatter = NumberFormat.getInstance();

        for (RankInfo rankInfo : RankInfo.values()) {
            int count = lottoGameResult.gameResult().getOrDefault(rankInfo, 0);
            long prizeMoney = rankInfo.getPrizeMoney();

            String formattedPrizeMoney = formatter.format(prizeMoney);

            System.out.println(rankInfo.getMatchNumberCnt() + "개 일치 (" + formattedPrizeMoney + "원) - " + count + "개");
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
