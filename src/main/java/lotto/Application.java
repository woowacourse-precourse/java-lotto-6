package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = 0;
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String inputAmount = Console.readLine();

            if (isValidInput(inputAmount)) {
                purchaseAmount = Integer.parseInt(inputAmount) / 1000;
                break;
            }
        }
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    private static boolean isValidInput(String input) {
        try {
            int inputAmount = Integer.parseInt(input);
            if (inputAmount % 1000 != 0) {
                System.err.println("[ERROR] 구입금액은 1000원 단위여야 합니다. 다시 입력해주세요.");
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] 구입금액은 숫자로 입력해주세요.");
            return false;
        }

    }
}
