package lotto.exception;

public class InvalidThousandWonFormatException extends IllegalArgumentException {

    private static final String INVALID_THOUSAND_WON_FORMAT_MESSAGE = "[ERROR] 1,000원 단위가 아닙니다.";

    public InvalidThousandWonFormatException() {
        super(INVALID_THOUSAND_WON_FORMAT_MESSAGE);
    }
}
