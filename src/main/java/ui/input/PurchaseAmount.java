package ui.input;

import camp.nextstep.edu.missionutils.Console;
import domain.ErrorMessage;

public class PurchaseAmount {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                validateAmount(amount);
                return amount;
            } catch (NumberFormatException e) {
                System.out.println(ErrorMessage.INVALID_NUMBER_FORMAT);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    private static void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT.toString());
        }
    }
}
