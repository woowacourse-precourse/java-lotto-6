package io.exception;

/**
 * 콘솔로부터 사용자 입력을 받아올 때,
 * <p>
 * 공백만 포함된 문자열일 경우에 발생하는 예외
 */
public final class BlankInputException extends IllegalArgumentException {
    public static final String BLANK_INPUT_EXCEPTION_MESSAGE = "입력은 빈 문자열이 될 수 없습니다.";

    public BlankInputException() {
        super(BLANK_INPUT_EXCEPTION_MESSAGE);
    }
}
