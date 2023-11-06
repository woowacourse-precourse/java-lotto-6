package lotto.exception;

public class InvalidBonusNumberFormatException extends InvalidBonusNumberException {

    private static final String messageFormat = "(%s)는 정수로 변환할 수 없는 보너스 번호입니다.";

    public InvalidBonusNumberFormatException(String bonusNumber) {
        super(String.format(messageFormat, bonusNumber));
    }
}
