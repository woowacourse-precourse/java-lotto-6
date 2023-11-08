package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static java.lang.Integer.parseInt;

public class InputView {
    private static final String VALIDATE_NUMBER_MESSAGE = "[ERROR] 숫자만 입력해야 합니다.";

    public static int inputLottoAmount() {
        String money = Console.readLine();
        System.out.println(money);
        try{
            int amount = parseInt(money);
            return amount;
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(VALIDATE_NUMBER_MESSAGE);
        }
    }
}
