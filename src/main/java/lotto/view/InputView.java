package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.TypeConvertor;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public Integer getMoney() {
        System.out.println(Message.INPUT_MONEY.message);
        String input = Console.readLine();
        return TypeConvertor.stringToInt(input);
    }

    private enum Message {
        INPUT_MONEY("구입금액을 입력해 주세요."),
        INPUT_MOVE_COUNT("시도할 회수는 몇회인가요?");

        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(message, replaces);
        }
    }
}
