package lotto.view;

import lotto.model.LottoRank;

import java.util.List;
import java.util.Map;

public class ConsoleOutputView {

    public void outputErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void outputBuyLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }

    public void outputLottoWinningResult(Map<LottoRank, Integer> lottoWinningResult) {
        Integer firstRankCount = lottoWinningResult.get(LottoRank.FIRST);
        Integer secondRankCount = lottoWinningResult.get(LottoRank.SECOND);
        Integer thirdRankCount = lottoWinningResult.get(LottoRank.THIRD);
        Integer fourthRankCount = lottoWinningResult.get(LottoRank.FOURTH);
        Integer fifthRankCount = lottoWinningResult.get(LottoRank.FIFTH);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthRankCount + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthRankCount + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdRankCount + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondRankCount + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstRankCount + "개");
    }
}
