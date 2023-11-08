package lotto.model.domain.exception;

import lotto.model.domain.constants.LottoGameConstants;

public class LottoException extends Exception {

    private LottoException() {
    }

    public static void rangeException() {
        throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 "
                + LottoGameConstants.MIN_NUMBER.getValue() + "이상 "
                + LottoGameConstants.MAX_NUMBER.getValue()
                + "이하여야 합니다.");
    }

    public static void duplicateException() {
        throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    public static void countException() {
        throw new IllegalArgumentException("[ERROR] 로또번호 형식이 맞지 않습니다.");
    }
}
