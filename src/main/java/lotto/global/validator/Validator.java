package lotto.global.validator;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

/**
 * 두 번 이상 사용되는 검증 로직을 구현한 클래스
 */
public final class Validator {
    /**
     * 문자열 입력이 숫자가 아닌 경우 예외를 반환하는 메서드
     *
     * @param message 문자열 입력
     */
    public static void validateNumber(final String message) {
        if (isNotNumber(message)) {
            throw LottoException.from(ErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static boolean isNotNumber(final String message) {
        return !message.matches("\\d+");
    }
}
