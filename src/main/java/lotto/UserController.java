package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserController {
    private UserController() {}

    public static int inputLottoPrice() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            String userInputLottoPrice = Console.readLine().trim();

            return Validation.getLottoPrice(userInputLottoPrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoPrice();
        }
    }

}
