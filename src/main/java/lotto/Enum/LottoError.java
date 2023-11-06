package lotto.Enum;

public enum LottoError {
    NumberCount("번호 개수가 6개가 아닙니다."),
    NumberDuplication("중복된 번호가 있습니다."),
    NumberRange("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NumberFormat("올바른 정수로 변환할 수 없는 값입니다"),
    AmountFormat("로또는 한장당 1000원 입니다.");

    private final String errorMessage;
    private LottoError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }

}
