package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class OutputView {

    public void printLottoTicketCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            List<Integer> sorted = lottoNumbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            System.out.println(sorted);
        }
    }

    public void printRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    public void printWinningResult(Map<Rank, Integer> winningResult) {
        System.out.println("당첨 통계\n---");
        DecimalFormat df = new DecimalFormat("###,###");
        List<Rank> rankKeySet = getRankKeySetWithoutNORANK(winningResult);
        for (Rank rank : rankKeySet) {
            String money = df.format(rank.getRewardMoney());
            System.out.printf("%d개 일치%s (%s원) - %d개\n", rank.getCorrectNumberCnt(), getBonusPrint(rank), money,
                    winningResult.get(rank));
        }
    }

    private List<Rank> getRankKeySetWithoutNORANK(Map<Rank, Integer> winningResult) {
        List<Rank> keySet = new ArrayList<>(winningResult.keySet());
        return keySet.stream()
                .sorted(Comparator.comparingInt(Rank::getRewardMoney))
                .filter(rank -> rank != Rank.NORANK)
                .collect(Collectors.toList());
    }

    private String getBonusPrint(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
