package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
    }

    private static int getPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                return parsePurchaseAmount(input);
            } catch (NumberFormatException e) {
                System.err.println("[ERROR] 숫자를 입력해 주세요. 다시 시도하세요.");
            }
        }
    }

    private static int parsePurchaseAmount(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("1,000 단위로 입력 해주세요");
        }
        return purchaseAmount / 1000;
    }
}
