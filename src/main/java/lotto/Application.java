package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_SIZE = 6;
    private static int purchasedPrice;

    public static void main(String[] args) {
        readPurchasedPrice();

    }

    public static void readPurchasedPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        purchasedPrice = Integer.parseInt(Console.readLine());
    }

    public static int getPurchasedPrice() {
        return purchasedPrice;
    }
}
