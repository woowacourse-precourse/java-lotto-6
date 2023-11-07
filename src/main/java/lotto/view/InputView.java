package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String NATURAL_NUMBER_REGEX = "^[0-9]*$";
    private final int LOTTO_TICKET_PRICE = 1000;

    private static final InputView instance = new InputView();

    private InputView() {

    }

    public static InputView getInstance() {
        return instance;
    }

    public String readPurchaseAmount() {
        String input = Console.readLine();
        try {
            validate(input);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readPurchaseAmount();
        }
        return input;
    }

    private void validate(String input) {
        if (isNotNaturalNumber(input) || isNotThousandUnit(input)) {
            throw new IllegalArgumentException(Message.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isNotNaturalNumber(String input) {
        return !input.matches(NATURAL_NUMBER_REGEX);
    }

    private boolean isNotThousandUnit(String input) {
        return Integer.parseInt(input) % LOTTO_TICKET_PRICE != 0;
    }

    enum Message {
        INVALID_PURCHASE_AMOUNT("구입 금액은 1,000원 단위만 가능합니다.");

        private final String message;

        Message(String message) {
            this.message = String.format("[Error] %s", message);
        }

        public String getMessage() {
            return message;
        }
    }
}
