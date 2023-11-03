package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.request.UserMoneyDto;
import lotto.util.BlankValidator;
import lotto.util.DigitsOnlyValidator;

public class InputView {
    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_FORMAT_EXCEPTION = "숫자(정수)형태의 문자열만 숫자로 변환할 수 있습니다.";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public UserMoneyDto readUserMoney() {
        println(MONEY_INPUT_MESSAGE);
        String rawUserMoney = Console.readLine();
        printEmptyLine();
        validateUserMoney(rawUserMoney);
        int userMoney = convertToInt(rawUserMoney);
        return new UserMoneyDto(userMoney);
    }

    private void validateUserMoney(String rawMoney) {
        BlankValidator.validate(rawMoney);
        DigitsOnlyValidator.validate(rawMoney);
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private void println(String message) {
        System.out.println(message);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private static class LazyHolder {
        private static final InputView INSTANCE = new InputView();

    }
}
