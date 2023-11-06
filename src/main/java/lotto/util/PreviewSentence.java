package lotto.util;

public enum PreviewSentence {
    INPUT_MONEY("구입금액을 입력해주세요."),
    SAY_LOTTO_COUNT("%d개를 구매했습니다."),
    LINE_SEPARATOR("\n"),
    INPUT_WIN_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    PreviewSentence(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int count) {
        return String.format(getMessage(), count);
    }
}
