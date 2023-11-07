package lotto.view;

import lotto.domain.winning.WinningStatistics;

import java.util.List;
import java.util.function.Consumer;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void printLottos(List<List<Integer>> lottos) {
        System.out.println();
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottos.size()));

        lottos.forEach(this::printLotto);
    }

    private void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
