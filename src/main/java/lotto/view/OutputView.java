package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        printPurchasedLottoCount(lottos.size());
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(number -> System.out.println(number));
    }

    public static void printPurchasedLottoCount(int count) {
        System.out.println();
        System.out.println(count + "개를 구매했습니다.");
    }
}