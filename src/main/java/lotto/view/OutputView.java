package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lottos;
import lotto.domain.Quantity;

public class OutputView {

    public void printQuantityOfLotteries(Quantity quantity) {
        System.out.printf("%d개를 구매했습니다. \n", quantity.getQuantity());
    }

    public void printBoughtLottos(Lottos lottos) {
        String boughtLottos = lottos.getLottos().stream()
                .map(lotto -> lotto.getNumbers() + "")
                .collect(Collectors.joining("\n"));
        System.out.println(boughtLottos);
    }
}
