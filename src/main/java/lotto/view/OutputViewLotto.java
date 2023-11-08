package lotto.view;


import lotto.domain.Lotto;

import java.util.List;

public class OutputViewLotto {
    public static void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumber());
        }
    }
}
