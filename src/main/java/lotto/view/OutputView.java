package lotto.view;

import java.util.List;

public class OutputView {

    public void showQuantityMessage(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void showLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void showIncomeRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }

    public static void showResultOfBoard(String condition, int count) {
        System.out.println(condition + " - " + count + "개");
    }

    public static void showErrorMessage(String error) {
        System.out.println("[ERROR]" + error);
    }
}
