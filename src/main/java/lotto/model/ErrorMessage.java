package lotto.model;

public enum ErrorMessage {
    INPUT_ONLY_NUMBER(" 숫자만 입력 가능합니다."),
    CANT_DIVIDE_1000(" 입력은 1000원 단위로만 가능합니다."),
    OVERLAP_NUMBER(" 중복된 숫자가 존재합니다."),
    INCORRECT_FORMAT(" 잘못된 형식의 입력입니다."),
    INCORRECT_SIZE(" 6개의 숫자로 구성되어야 합니다."),
    INCORRECT_RANGE(" 1~45의 숫자들만 입력 가능합니다.");

    private static final String START_IN_MESSAGE = "[ERROR]";
    private String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return START_IN_MESSAGE+message;
    }
}
