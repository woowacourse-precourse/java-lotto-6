package lotto.view;

import java.util.List;

public class OutputView {
    public void showQuantityMessage(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void showLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public static void showResultOfBoard(String situation, int count) {
        System.out.println(situation + " - " + count + "개");
    }
}
