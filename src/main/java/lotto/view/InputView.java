package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchasePrice;
import lotto.util.TypeConvertor;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public PurchasePrice getMoney() {
        System.out.println(Message.INPUT_MONEY.message);
        String input = Console.readLine();
        Integer convertInput = TypeConvertor.stringToInt(input);
        return PurchasePrice.of(convertInput);
    }

    private enum Message {
        INPUT_MONEY("구입금액을 입력해 주세요.");

        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(message, replaces);
        }
    }
}
