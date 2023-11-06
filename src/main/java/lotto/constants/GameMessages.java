package lotto.constants;

public enum GameMessages {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_LOTTO( "당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호 입력해 주세요."),
    OUTPUT_STATISTICS("당첨 통계");

    private final String message;

    GameMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return CommonLetter.NEW_LINE.getLetter() + message;
    }
}
