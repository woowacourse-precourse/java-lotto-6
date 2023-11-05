package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(("%n%s개를 구매했습니다.%n"), lottos.size());
        System.out.println(lottos.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
