package lotto.domain;

public enum LottoErrorMessages {
    INVALID_NUMBER_RANGE(
            String.format("Lotto 숫자는 %d부터 %d까지 입니다.",
                    LottoConfig.MIN_NUMBER.getValue(),
                    LottoConfig.MAX_NUMBER.getValue()));
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
