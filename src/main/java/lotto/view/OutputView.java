package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BUDGET_INPUT_DESC = "구입금액을 입력해 주세요.";
    private static final String ISSUED_LOTTO_DESC = "개를 구매했습니다.";

    public static void printBudgetInputDescription() {
        System.out.println(BUDGET_INPUT_DESC);
    }

    public static void printLottoStatusDescription(int amount) {
        System.out.printf("%d%s%n", amount, ISSUED_LOTTO_DESC);
    }

    public static void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }
}
