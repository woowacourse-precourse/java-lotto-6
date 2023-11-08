package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;

public class LottoUI {

    public int purchase() {
        boolean isValidInput = false;
        int amount = 0;

        while (!isValidInput) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String userInput = Console.readLine();
                amount = Integer.parseInt(userInput);
                isAmountValid(amount);
                isValidInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.NOT_VALID_AMOUNT.getMessage());
            }
        }

        return amount;
    }

    private void isAmountValid(int amount) {
        int count = amount / 1_000;
        if (count == 0) {
            throw new IllegalArgumentException();
        }
    }
}
