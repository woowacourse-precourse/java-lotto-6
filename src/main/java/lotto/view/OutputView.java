package lotto.view;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.Lotto;

public class OutputView {
    private static final String LOTTO_COUNT_OF_PURCHASES_FORMAT = "%d개를 구매했습니다.";

    public void printLottoCountOfPurchase(int lottosCount) {
        System.out.println(String.format(LOTTO_COUNT_OF_PURCHASES_FORMAT, lottosCount));
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
    }
}
