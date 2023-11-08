package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).toString());
        }
    }

    public void printResult(List<Rank> results) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (int i = 0; i < results.size(); i++) {
            rankCount.put(results.get(i), rankCount.getOrDefault(results.get(i), 0) + 1);
        }

        printFifthPlace(rankCount.getOrDefault(Rank.FIFTH_PLACE, 0));
        printFourthPlace(rankCount.getOrDefault(Rank.FOURTH_PLACE, 0));
        printThirdPlace(rankCount.getOrDefault(Rank.THIRD_PLACE, 0));
        printSecondPlace(rankCount.getOrDefault(Rank.SECOND_PLACE, 0));
        printFirstPlace(rankCount.getOrDefault(Rank.FIRST_PLACE, 0));
    }

    public void printFifthPlace(int count) {
        System.out.printf("3개 일치 (%,d원) - %d개\n", Rank.FIFTH_PLACE.getWinningPrice(), count);
    }

    public void printFourthPlace(int count) {
        System.out.printf("4개 일치 (%,d원) - %d개\n", Rank.FOURTH_PLACE.getWinningPrice(), count);
    }

    public void printThirdPlace(int count) {
        System.out.printf("5개 일치 (%,d원) - %d개\n", Rank.THIRD_PLACE.getWinningPrice(), count);
    }

    public void printSecondPlace(int count) {
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", Rank.SECOND_PLACE.getWinningPrice(), count);
    }

    public void printFirstPlace(int count) {
        System.out.printf("6개 일치 (%,d원) - %d개\n", Rank.FIRST_PLACE.getWinningPrice(), count);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

}
