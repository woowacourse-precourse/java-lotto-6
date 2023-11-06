package lotto.view;

import lotto.Lotto;
import lotto.constant.ConsoleMessage;

import java.util.List;

import static lotto.constant.ConsoleMessage.LOTTO_PURCHASE_COMPLETED;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf((LOTTO_PURCHASE_COMPLETED), lottos.size());

        lottos.forEach(System.out::println);
    }
}
