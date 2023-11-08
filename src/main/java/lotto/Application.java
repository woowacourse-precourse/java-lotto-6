package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("구매금액을 입력해 주세요.");
        Integer purchaseAmount;

        while (true) {
            try {
                String purchaseAmountString = Console.readLine();
                purchaseAmount = Validator.purchaseAmountValidation(purchaseAmountString);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 구매금액을 입력해주세요.");
            }
        }

        System.out.println(purchaseAmount);

    }
}
