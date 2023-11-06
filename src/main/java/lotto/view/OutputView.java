package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.enums.LottoPrize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void displayLottoTickets(LottoCount lottoCount, List<Lotto> lottoTickets) {
        System.out.println();
        System.out.println(lottoCount.getLottoCount() + "개를 구매했습니다.");

        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }

    public void displayLottoResults(List<LottoPrize> allLottoPrizes) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        List<LottoPrize> ranks = List.of(LottoPrize.FIFTH, LottoPrize.FOURTH, LottoPrize.THIRD, LottoPrize.SECOND, LottoPrize.FIRST);

        Map<LottoPrize, Integer> lottoPrizeResults = LottoPrize.lottoPrizeCount(allLottoPrizes);

        for (LottoPrize rank : ranks) {
            Integer count = lottoPrizeResults.get(rank);
            if (rank == LottoPrize.SECOND) {
                System.out.println(rank.matchCount + "개 일치, 보너스 볼 일치 " + "(" + rank.prizeMoneyForPrint + ") - " +
                        count + "개");
            }
            System.out.println(rank.matchCount + "개 일치 " + "(" + rank.prizeMoneyForPrint + ") - " +
                    count + "개");
        }
    }
}
