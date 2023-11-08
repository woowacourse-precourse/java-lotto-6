package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.message.Inquire;
import lotto.message.Result;

import java.util.List;
import java.util.Map;

import static lotto.message.Result.ANNOUNCE_INIT;

public class OutputHandler {

    void printMessage(Inquire message) {
        message.printMessage();
    }

    public void printPurchaseHistory(List<Lotto> lottoBundle) {
        System.out.println(lottoBundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoBundle) {
            System.out.println(lotto.toString());
        }
    }

    public void printResults(Map<LottoRank, Integer> winningResults, double profitRate) {
        System.out.println(ANNOUNCE_INIT.getMessage());
        System.out.printf(Result.FIFTH_PLACE.getMessage() + "%n", winningResults.get(LottoRank.FIFTH_PLACE));
        System.out.printf(Result.FOURTH_PLACE.getMessage() + "%n", winningResults.get(LottoRank.FOURTH_PLACE));
        System.out.printf(Result.THIRD_PLACE.getMessage() + "%n", winningResults.get(LottoRank.THIRD_PLACE));
        System.out.printf(Result.SECOND_PLACE.getMessage() + "%n", winningResults.get(LottoRank.SECOND_PLACE));
        System.out.printf(Result.FIRST_PLACE.getMessage() + "%n", winningResults.get(LottoRank.FIRST_PLACE));
        System.out.printf(Result.TOTAL_PROFIT_RATE.getMessage() + "%n", profitRate);
    }
}
