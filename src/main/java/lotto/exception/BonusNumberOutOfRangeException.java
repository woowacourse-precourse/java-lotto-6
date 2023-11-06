package lotto.exception;

public class BonusNumberOutOfRangeException extends InvalidBonusNumberException {

    private static final String messageFormat = "보너스 번호가 유효한 범위를 벗어났습니다. 입력된 번호 : %d";

    public BonusNumberOutOfRangeException(Integer bonusNumber) {
        super(String.format(messageFormat, bonusNumber));
    }
}

