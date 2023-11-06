package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView instance = new InputView();

    public static InputView getInstance(){
        return instance;
    }
    private InputView() {
    }

    public String readLottoMoney() {
        System.out.println(Message.INPUT_LOTTO_MONEY.message);
        String input = Console.readLine();
        return input;
    }

    private enum Message {
        INPUT_LOTTO_MONEY("구입금액을 입력해 주세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}