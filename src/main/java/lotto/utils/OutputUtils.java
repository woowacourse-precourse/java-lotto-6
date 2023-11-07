package lotto.utils;

import lotto.constants.Message;
import lotto.domain.Lotto;
import lotto.constants.Rank;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputUtils {

    public void displayPayMoneyRequestMessage() {
        System.out.println(Message.PAY_MONEY_REQUEST_MESSAGE);
    }

    public void displayBuyLottos(List<Lotto> buyLottos) {
        System.out.println(buyLottos.size() + Message.BUY_LOTTO_COUNT_MESSAGE);

        for (Lotto buyLotto : buyLottos) {
            System.out.println(buyLotto.toString());
        }
    }

    public void displayWinningLottoRequestMessage() {
        System.out.println(Message.WINNING_NUMBER_REQUEST_MESSAGE);
    }

    public void displayBonusNumberRequestMessage() {
        System.out.println(Message.BONUS_NUMBER_REQUEST_MESSAGE);
    }

    public void displayLottoResult(Map<Rank, Integer> lottoResults, String profitRate) {
        System.out.println(Message.LOTTO_WIN_RESULT_MESSAGE);
        displayRank(lottoResults);
        displayProfitRate(profitRate);
    }

    private void displayRank(Map<Rank, Integer> lottoResults) {
        Set<Rank> ranks = lottoResults.keySet();

        for (Rank rank : ranks) {
            System.out.println(rank.toString() + " - " + lottoResults.get(rank) + "개");
        }
    }

    private void displayProfitRate(String profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }


    public void displayErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
