package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
