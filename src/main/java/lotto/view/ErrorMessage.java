package lotto.view;

public final class ErrorMessage {
    public static String EMPTY_INPUT_ERROR="[ERROR] 공백 입력은 불가능합니다.";

    public static String NOT_PARSE_INTEGER = "[ERROR] 숫자를 입력해 주세요.";

    public static String NOT_VALID_MONEY="[ERROR] 1000 단위의 양의 정수 입력만 가능합니다.";
    public static String NOT_VALID_LENGTH = "[ERROR] 로또 번호는 공백 없이 컴마(,)를 구분자로 양의 정수 6개만 입력이 가능합니다.";
    public static String OUT_OF_RANGE_NUMBER = "[ERROR] 숫자는 1~45까지만 입력이 가능합니다.";
    public static String NOT_COMPOSED_OF_UNIQUE_NUMBERS = "[ERROR] 로또 번호는 중복돼서는 안됩니다.";

    private ErrorMessage(){}
}
