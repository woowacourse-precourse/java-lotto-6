package lotto.view;

public enum LottoGuideMessage {

    INPUT_MONEY("구입금액을 입력해 주세요."),
    BOUGHT_LOG("개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보녀스 번호를 입력해 주세요."),
    ;

    private final String message;

    LottoGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
