package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;
import lotto.domain.Amount;

public class InputView {

    public static Amount inputAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            return new Amount(amount);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NUMBER.message());
        }
    }
}
