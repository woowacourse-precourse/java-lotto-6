package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class Input {

    private static final String MESSAGE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";

    public int getPurchaseAmount() {
        System.out.println(MESSAGE_INPUT_AMOUNT);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
