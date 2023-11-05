package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.system.SystemMessage;

public class OutputView {
    public static void exceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printFrom(SystemMessage systemMessage) {
        System.out.println(systemMessage.getMessage());
    }

    public static void printPurchasedLottos(PurchasedLottos purchasedLottos) {
        System.out.printf(SystemMessage.OUTPUT_PURCHASED_LOTTOS.getMessage(), purchasedLottos.getsize());
        purchasedLottos.stream()
                .map(Lotto::get)
                .forEach(System.out::println);
    }
}
