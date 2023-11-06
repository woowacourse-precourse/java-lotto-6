package lotto.Enum;

public enum LottoError {
    NumberCount("번호 개수가 6개가 아닙니다."),
    NumberDuplication("중복된 번호가 있습니다."),
    NumberRange("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NumberFormat("올바른 정수로 변환할 수 없는 값입니다"),
    AmountFormat("로또 금액 형식에 맞지 않습니다.(로또 한장당 1000원 입니다.)"),
    BonusFormat("보너스 번호는 당첨 번호와 중복이 불가능 합니다.");

    private final String errorMessage;

    LottoError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }

}
