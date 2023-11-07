package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    private static final int LOTTO_PRICE = 1000;

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseQuantity = Integer.parseInt(Console.readLine());

        checkInputMoney(purchaseQuantity);

        return purchaseQuantity;
    }

    private static void checkInputMoney(int purchaseQuantity) {
        if (purchaseQuantity % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1000원 단위로 입력 가능합니다.");
        }

    }
}
