package lotto;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputSystem {
    private static final String ENTER_PRICE = "구입금액을 입력해 주세요.";
    private static final String ENTER_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String IS_ONLY_NUMBER = "[0-9]+"; // 숫자로만 되어있으면 true 반환
    private static final String ERROR_MESSAGE = "[ERROR]";

    public void purchase(List<Integer> drawed) {
        try {
            String price = enter(ENTER_PRICE);

        } catch (Exception e) {

        }

    }
    public String enter(String announcement) {
        System.out.println(announcement);
        return Console.readLine();
    }

    private boolean isPriceValid(String input, List<Integer> drawed) {
        isInteger(input);
        isKUnit(input);
        return true;
    }
    private void isInteger(String input) {
        if (!input.matches(IS_ONLY_NUMBER)) {
            throw new IllegalStateException();
        }
    }
    private void isKUnit(String input) {
        if (Integer.parseInt(input) % 1000 != 0)
            throw new IllegalArgumentException();
    }
}
