package lotto.view;

import lotto.model.GroupLotto;

public class PrintPurchaseLotto {
    public static void printLotto(GroupLotto groupLotto) {
        groupLotto.getLottos().forEach(System.out::println);
        System.out.println();
    }
}
