package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.ErrorMessage;

public class LottoManager {

    private int amount;

    LottoManager() {
        this.amount = 0;
    }

    public void deposit() {
        System.out.println("구입금액을 입력해 주세요.");
        this.amount += getValidAmount();
    }

    private int getValidAmount() {
        while (true) {
            try {
                String input = Console.readLine();
                validateNumericInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_AMOUNT_INVALID_MEASURE.getMessage());
        }
    }
}
