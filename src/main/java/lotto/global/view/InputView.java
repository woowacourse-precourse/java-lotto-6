package lotto.global.view;

import static lotto.domain.enums.ErrorMessage.NOT_NUMBER_INPUT_ERROR_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ENTER = System.lineSeparator();
    private static final String BUY_LOTTO_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASED_COUNT_MESSAGE = ENTER + "%d개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MESSAGE = ENTER + "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = ENTER + "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    private static int getInt() {
        try {
            String input = Console.readLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_INPUT_ERROR_MESSAGE.getMessage());
        }
    }

    public static int getPurchaseMoney() {
        while (true) {
            System.out.println(BUY_LOTTO_MESSAGE);
            try {
                return getInt();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
