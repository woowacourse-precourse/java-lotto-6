package lotto.validator;

import lotto.model.Lotto;

public class ValidateObject{
    private static final String ERROR_MESSAGE = "[ERROR]";
    private ValidateObject(){}
    public static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        winningLotto.getNumbers().stream()
                .filter(s -> s.equals(bonusNumber))
                .forEach(s -> ValidateObject.throwException()); //  validate 클래스로 분리된 메소드에 접근할것

    }
    private static void throwException(){
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
