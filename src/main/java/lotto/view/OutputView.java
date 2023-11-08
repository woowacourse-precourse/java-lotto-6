package lotto.view;

import static lotto.domain.LotteryRanking.LOTTO_1ST_PLACE;
import static lotto.domain.LotteryRanking.LOTTO_2ST_PLACE;
import static lotto.domain.LotteryRanking.LOTTO_3ST_PLACE;
import static lotto.domain.LotteryRanking.LOTTO_4ST_PLACE;
import static lotto.domain.LotteryRanking.LOTTO_5ST_PLACE;
import static lotto.view.OutputMessage.BOUGHT_LOTTO;
import static lotto.view.OutputMessage.FIVE_BONUS_MATCHES;
import static lotto.view.OutputMessage.FIVE_MATCHES;
import static lotto.view.OutputMessage.FOUR_MATCHES;
import static lotto.view.OutputMessage.SIX_MATCHES;
import static lotto.view.OutputMessage.THREE_MATCHES;
import static lotto.view.OutputMessage.WINNING_STATISTICS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoRamdomNumbers;

public class OutputView {

    public void printIssuedLottoNumbersInAscendingOrder(List<Lotto> ramdomNumbersList) {
        System.out.println(ramdomNumbersList.size() + BOUGHT_LOTTO.getMessage());
        for (Lotto lotto : ramdomNumbersList) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public void printWinningDetails(LottoMachine lottoMachine) {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println("---");
        System.out.println(
                THREE_MATCHES.getMessage() + lottoMachine.getWinningDetails()
                        .getOrDefault(LOTTO_5ST_PLACE.getRankingKey(), 0)
                        + "개");
        System.out.println(
                FOUR_MATCHES.getMessage() + lottoMachine.getWinningDetails()
                        .getOrDefault(LOTTO_4ST_PLACE.getRankingKey(), 0)
                        + "개");
        System.out.println(
                FIVE_MATCHES.getMessage() + lottoMachine.getWinningDetails()
                        .getOrDefault(LOTTO_3ST_PLACE.getRankingKey(), 0)
                        + "개");
        System.out.println(
                FIVE_BONUS_MATCHES.getMessage() + lottoMachine.getWinningDetails()
                        .getOrDefault(LOTTO_2ST_PLACE.getRankingKey(), 0)
                        + "개");
        System.out.println(
                SIX_MATCHES.getMessage() + lottoMachine.getWinningDetails()
                        .getOrDefault(LOTTO_1ST_PLACE.getRankingKey(), 0) + "개");
    }

    public void printReturnOnInvestment(LottoMachine lottoMachine) {
        System.out.println("총 수익률은 " + lottoMachine.getProfitRate() + "%입니다.");
    }
}
