package lotto;
import camp.nextstep.edu.missionutils.Console;

public class InputSystem {
    private static final String IS_ONLY_NUMBER = "[0-9]+"; // 숫자로만 되어있으면 true 반환
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static int money = 0;
    public void purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputmoney = Console.readLine();

        if (isMondeyValid(inputmoney)) {
            money = Integer.parseInt(inputmoney);
        }
    }
    private boolean isMondeyValid(String input) {
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
