package lotto.util;

import lotto.domain.Lottos;

public class Writer {

    private static final String PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static void purchaseAmount(){
        System.out.println(PURCHASE_AMOUNT);
    }

    public static void lottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void winningNumbers() {
        System.out.println(WINNING_NUMBERS);
    }
}
