package lotto.system.shop.exception.machine;

public class DuplicatedBonusNumberException extends IllegalArgumentException {

    private static final String DUPLICATED_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 중복될 수 없습니다.";

    public DuplicatedBonusNumberException() {
        super(DUPLICATED_BONUS_NUMBER_MESSAGE);
    }
}
