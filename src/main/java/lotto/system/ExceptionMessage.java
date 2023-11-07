package lotto.system;

public enum ExceptionMessage {
    LOTTO_LENGTH(String.format("로또 번호는 %d 가지 숫자여야 합니다.", LottoNumberConstant.LENGTH.getValue())),
    LOTTO_DISTINCT("중복되는 로또 번호가 있으면 안 됩니다."),
    LOTTO_RANGE(String.format("로또 번호는 %d 부터 %d 사이의 숫자여야 합니다.", LottoNumberConstant.MIN.getValue(),
            LottoNumberConstant.MAX.getValue())),
    MONEY_NOT_DIVISIBLE(String.format("로또 구입 금액은 %d원으로 나누어 떨어져야 합니다.",
            SystemConstant.LOTTO_TICKET_PRICE.getValue())),
    MONET_NOT_ENOUGH("로또를 구입할 충분한 돈이 없거나 음수가 주어졌습니다."),
    NUMERIC("숫자가 아닌 값이 입력되었습니다."),
    EMPTY("입력이 주어지지 않았습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
