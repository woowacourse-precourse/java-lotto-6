package lotto.view;

import lotto.domain.Lottos;

public enum OutputView {
    // Request
    ASK_INPUT_MONEY("구입금액을 입력해 주세요."),
    ASK_INPUT_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_INPUT_BONUS("보너스 번호를 입력해 주세요."),

    PURCHASE_RESULT("개를 구매했습니다."),
    RETURN_RESULT("총 수익률은 %d 입니다.");


    private final String message;

    OutputView(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
