package lotto.View;

import static lotto.Exception.ExceptionMessage.TYPE_ERROR;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static int inputAmount() {
        try {
            System.out.println(INPUT_LOTTO_AMOUNT);
            return Integer.parseInt(Console.readLine());
        }catch (IllegalArgumentException e){
            System.out.println("\n"+TYPE_ERROR.getExceptionMessage());
            return inputAmount();
        }
    }

    private static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(TYPE_ERROR.getExceptionMessage());
        }
    }
}
