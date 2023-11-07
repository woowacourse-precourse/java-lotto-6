package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String outputResultMessage = "당첨통계\n---";
    private static final String outputLottoStringBase = "%d개를 구매했습니다.\n";
    private static final String outputResultBase = "%s (%s원) -  %d개\n";

    public void outputLotto(List<Lotto> lottos) {
        String outputLotto = String.format(outputLottoStringBase, lottos.size());
        for (Lotto lotto : lottos) {
            System.out.print("[");
            lotto.getNumbers().stream().forEach(n -> System.out.print(n + ", "));
            System.out.println("\b\b]");
        }
    }

    public void outputRank(Map<Rank, Integer> rank) {
        System.out.println(outputResultMessage);
        Arrays.stream(Rank.values()).forEach(n -> System.out.printf(outputResultBase,
                n.getReply(), n.getMoenyWithComma(), rank.getOrDefault(n, 0)));
    }
}
