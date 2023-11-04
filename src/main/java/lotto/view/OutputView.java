package lotto.view;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void requestInputAmountMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void requestInputWinningNumbersMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void requestInputBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    private final int COUNT_ZERO = 0;
    public void purchaseMessage(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public void lottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void winningStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---");
    }

    public void showRankResult(HashMap<Rank, Integer> map) {
        for (Rank rank : Rank.values()) {
            showSingleRankResult(map, rank);
        }
    }

    private void showSingleRankResult(HashMap<Rank, Integer> map, Rank rank) {
        if (rank.getCount()==COUNT_ZERO) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    rank.getCount(), rank.getPrizeAmount(), map.get(rank));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCount(), rank.getPrizeAmount(), map.get(rank));
    }

    public void showRateOfReturn(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }
}
