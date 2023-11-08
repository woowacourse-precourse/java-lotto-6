package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final String START = "구입금액을 입력해 주세요.";

    private static final String PURCHASE = "개를 구매했습니다.";
    private static final String ERROR_PRICE = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";

    public static void main(String[] args) {
        int purchaseAmount = 0;
        while (true) {
            try {
                System.out.println(START);
                purchaseAmount = Integer.parseInt(readLine());
                checkPrice(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PRICE);
            }
        }
        int numberOfLotto = purchaseAmount / LOTTO_PRICE;

        System.out.println();
        System.out.println(numberOfLotto + PURCHASE);

        Lotto.startLotto(numberOfLotto, purchaseAmount);

    }


    public static void checkPrice(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

}
