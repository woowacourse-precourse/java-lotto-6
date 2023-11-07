package lotto.constants;

public interface ErrorMessage {

    String START_ERROR_MESSAGE = "[ERROR] ";
    default String entireMessage() {
        return (START_ERROR_MESSAGE + getMessage());
    }

    String getMessage();
}
