package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.util.message.Output.PURCHASE_COUNT;

public class OutputLotto {
    public static void counts(int purchaseCount) {
        System.out.println("\n" + purchaseCount + PURCHASE_COUNT);
    }

    public static void numbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
