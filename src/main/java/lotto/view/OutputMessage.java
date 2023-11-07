package lotto.view;

import lotto.domain.Lotto;

public enum OutputMessage {

    OUTPUT_PURCHASE_AMOUNT_MESSAGE("%d개를 구입했습니다."),
    OUTPUT_LOTTO_MESSAGE("%s");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int value) {
        return String.format(this.message, value);
    }

    public String getMessage(Lotto lotto) {
        return lotto.toString();
    }
}
