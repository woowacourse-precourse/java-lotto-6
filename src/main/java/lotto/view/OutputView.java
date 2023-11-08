package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String outputResultMessage = "당첨 통계\n---";
    private static final String outputLottoStringBase = "%d개를 구매했습니다.\n";
    private static final String outputResultBase = "%s (%s원) - %d개\n";
    private static final String outputRateOfReturn = "총 수익률은 %.1f%%입니다.";

    public void outputLotto(List<Lotto> lottos) {
        System.out.printf(outputLottoStringBase, lottos.size());

        for (Lotto lotto : lottos) {
            String result = "[" + lotto.getNumbers().stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")) + "]";
            System.out.println(result);
        }

    }

    public void outputRank(Map<Rank, Integer> rank, float rateOfReturn) {
        System.out.println(outputResultMessage);
        Arrays.stream(Rank.values()).sorted(Comparator.reverseOrder())
                .filter(r -> r != Rank.NONE)
                .forEach(n -> System.out.printf(outputResultBase,
                        n.getReply(), n.getMoneyWithComma(), rank.getOrDefault(n, 0)));
        System.out.printf(outputRateOfReturn, rateOfReturn);
    }
}
