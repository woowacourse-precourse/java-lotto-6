package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_ONE_PRICE = 1000;


    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_ONE_PRICE;
    }

    private static int inputPurchaseAmount() {
        int purchaseAmount = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                purchaseAmount = Integer.parseInt(Console.readLine());
                isValidInput = checkPurchaseAmount(purchaseAmount);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자를 입력해 주세요.");
            }
        }
        return purchaseAmount;
    }

    private static boolean checkPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % LOTTO_ONE_PRICE != 0) {
            System.out.println("[ERROR] 구입금액은 " + LOTTO_ONE_PRICE + "원 단위의 양수여야 합니다.");
            return false;
        }
        return true;
    }
}
