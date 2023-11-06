package lotto.view.constants;

import static lotto.domain.constants.LottoConfig.LOTTO_COUNT;

public enum ViewMessage {
    GET_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_PURCHASE_NOTICE_MESSAGE(
            String.format("%d개를 구매했습니다.", LOTTO_COUNT.getValue())
    ),
    GET_WINNING_NUMBER("당첨 번호를 입력해 주세요.");
    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
