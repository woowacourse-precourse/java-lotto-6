package lotto.ui;

import lotto.Lotto;

import java.util.List;

import static lotto.domain.Message.PURCHASE_COMMENT;

public class OutputView {
    public static void printLotto(List<Lotto> myLotto) {
        System.out.printf(PURCHASE_COMMENT.getMessage(), myLotto.size());
        for (Lotto lotto : myLotto) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

}
