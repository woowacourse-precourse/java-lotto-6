package lotto.utils;

public enum PrintingMessage {
    GET_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요.");

    private String message;

    PrintingMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
    }
