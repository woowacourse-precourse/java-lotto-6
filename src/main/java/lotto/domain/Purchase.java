package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class Purchase {
    public static final int LOTTO_PRICE = 1000;

    public static int inputMoney() throws IllegalArgumentException {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int purchaseQuantity = Integer.parseInt(Console.readLine());
                checkInputMoney(purchaseQuantity);
                return purchaseQuantity;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void checkInputMoney(int purchaseQuantity) {
        if (purchaseQuantity < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1000원 이상 입력 가능합니다.");
        }
        if (purchaseQuantity % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입금액은 1000원 단위로 입력 가능합니다.");
        }
    }

    public static int calculateQuantity(int purchaseQuantity) {
        return purchaseQuantity / LOTTO_PRICE;
    }

    private static void printQuantity(int purchaseQuantity) {
        int confirmQuantity = calculateQuantity(purchaseQuantity);
        System.out.println(confirmQuantity + "개를 구매했습니다.");
    }

}
