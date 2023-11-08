package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String CHECK_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void printInputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
    }

    public static void printCheckAmount(int amount) {
        System.out.printf(CHECK_AMOUNT_MESSAGE + "%n", amount);
    }

    public static void printPurchasedNumbers(List<Lotto> purchasedNumbers) {
        for (Lotto lotto : purchasedNumbers) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void printWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
    }
}
