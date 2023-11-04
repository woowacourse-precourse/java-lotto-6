package lotto;

import java.util.List;

public class OutputView {

    public void printPurchasedLottos(List<Lotto> purchasedLottos) {
        System.out.printf("%d개를 구매했습니다.\n", purchasedLottos.size());
        for (Lotto purchasedLotto : purchasedLottos) {
            printPurchasedLotto(purchasedLotto);
        }
    }

    private void printPurchasedLotto(Lotto purchasedLotto) {
        List<Integer> numbers = purchasedLotto.getNumbers();
        List<Integer> list = numbers.stream()
                .sorted()
                .toList();

        System.out.println(list);
    }
}
