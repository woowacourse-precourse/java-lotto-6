package lotto;
import camp.nextstep.edu.missionutils.Console;

public class InputSystem {
    private final String ENTER_PRICE = "구입금액을 입력해 주세요.";
    private final String ENTER_LOTTO = "당첨 번호를 입력해 주세요.";
    private final String ENTER_BONUS = "보너스 번호를 입력해 주세요.";
    private static final String IS_ONLY_NUMBER = "[0-9]+"; // 숫자로만 되어있으면 true 반환
    private static final String ERROR_MESSAGE = "[ERROR]";

    public int purchase() {
        return isPriceValid(enter(ENTER_PRICE));
    }
    private String enter(String announcement) {
        System.out.println(announcement);
        return Console.readLine();
    }
    private int isPriceValid(String price) {
        if (isInteger(price) && isKUnit(price))
            return Integer.parseInt(price) / 1000;
        throw new IllegalStateException();
    }
    private boolean isInteger(String price) {
        return price.matches(IS_ONLY_NUMBER);
    }
    private boolean isKUnit(String price) {
        if (Integer.parseInt(price) % 1000 == 0)
            return true;
        return false;
    }

    public void getNumbers() {
        enter(ENTER_LOTTO).split(",");
    }
}
