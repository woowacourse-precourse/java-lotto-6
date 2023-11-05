package lotto.domain;

public enum LottoErrorMessages {
    INVALID_NUMBER_RANGE(
            String.format("Lotto 숫자는 %d부터 %d까지 입니다.",
                    LottoConfig.MIN_NUMBER.getValue(),
                    LottoConfig.MAX_NUMBER.getValue())),
    INVALID_SIZE(String.format("로또 숫자는 %d개여야 합니다.", LottoConfig.NUMBER_COUNT.getValue())),
    DUPLICATE_NUMBERS("로또 숫자는 중복될 수 없습니다."),
    NEGATIVE_AMOUNT("금액은 양수여야 합니다.");
    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formattedMessage(int min, int max) {
        return String.format(message, min, max);
    }

}
