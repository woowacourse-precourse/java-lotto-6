package lotto.ui;

import lotto.Lotto;
import java.util.List;

public class OutputManager {

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        lottos.stream().map(Lotto::getNumbers)
                .sorted()
                .forEach(System.out::println);
    }
}
