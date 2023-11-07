package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public static void run() {
        int purchaseAmount = getValidPurchaseAmount();
    }

    private static int getValidPurchaseAmount() {
        int purchaseAmount = 0;

        do {
            int inputAmount = 0;
            try {
                inputAmount = getPurchaseAmountFromUser();
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 유효한 숫자를 입력해야 합니다.");
                continue; // Restart the loop if there's an exception
            }

            if (inputAmount % 1000 != 0) {
                System.out.println("[ERROR] 1,000원 단위로 입력해야 합니다.");
            } else if (inputAmount == 0) {
                System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            } else {
                purchaseAmount = inputAmount;
            }
        } while (purchaseAmount == 0);

        return purchaseAmount;
    }
    private static int getPurchaseAmountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
