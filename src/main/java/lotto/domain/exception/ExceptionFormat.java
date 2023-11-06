package lotto.domain.exception;

public final class ExceptionFormat {
    public static final String formatException(String exceptionMessage) {
        return String.format("[ERROR]%s", exceptionMessage);
    }
}
