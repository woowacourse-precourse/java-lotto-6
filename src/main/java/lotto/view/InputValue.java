package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Purchase;
import lotto.utility.PurchaseErrorMessage;

public class InputValue {
    public static int inputPurchase() {
        while (true) {
            try {
                System.out.println(InputMessage.PURCHASE.getMessage());
                String input = Console.readLine();
                int purchaseAmount = Integer.parseInt(input);
                Purchase purchase = new Purchase(purchaseAmount); // Purchase 클래스에서 유효성 검증 수행
                return purchase.getAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
