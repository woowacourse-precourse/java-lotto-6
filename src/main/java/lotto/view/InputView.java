package lotto.view;

import java.util.function.Supplier;

import static lotto.ErrorMessage.PURCHASE_MONEY_ERROR;

public class InputView {
    private static final String PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    private final Supplier<String> reader;

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public int readPurchaseMoney() {
        System.out.println(PURCHASE_MONEY_MESSAGE);

        try {
            return Integer.parseInt(reader.get());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_MONEY_ERROR.getMessage());
        }
    }
}
