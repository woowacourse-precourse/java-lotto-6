package lotto.exception;

public class BonusNumberDuplicatedException extends InvalidBonusNumberException {

    private static final String messageFormat = "보너스 번호가 기존 로또 번호와 중복되었습니다. 입력된 번호 : %d";

    public BonusNumberDuplicatedException(Integer bonusNumber) {
        super(String.format(messageFormat, bonusNumber));
    }
}
