package lotto.game.views.enums;

import lotto.enums.GlobalMessage;

public enum LottosViewMessage {

    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ANNOUNCE_PURCHASE_LOTTOS_COUNT("개를 구매했습니다."),
    ;

    private final String message;

    LottosViewMessage(String message) {
        this.message = message;
    }

    public static String showNumberOfPurchaseLottos(int size) {
        return GlobalMessage.NEW_LINE.get()
                + size
                + ANNOUNCE_PURCHASE_LOTTOS_COUNT.get();
    }

    public String get() {
        return message;
    }

}
