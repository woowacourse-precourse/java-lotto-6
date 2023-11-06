package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public long getMoneyInput() {
        System.out.println(GET_MONEY_MESSAGE);
        String input = Console.readLine();
        validate(input);
        return Long.parseLong(input);
    }

    private void validate(String input) {
        if(!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
