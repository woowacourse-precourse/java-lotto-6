package lotto;

public final class ErrorMessage {
    public static String EMPTY_INPUT_ERROR="[ERROR] 숫자 입력이 필요합니다.";
    public static String NOT_VALID_MONEY="[ERROR] 1000 단위의 양의 정수 입력만 가능합니다.";
    public static String NOT_VALID_LENGTH = "[ERROR] 숫자는 공백 없이 컴마(,)를 구분자로 양의 정수 6개만 입력이 가능합니다.";
    public static String OUT_OF_RANGE_NUMBER = "[ERROR] 숫자는 1~45까지만 입력이 가능합니다.";
    public static String NOT_COMPOSED_OF_UNIQUE_NUMBERS = "[ERROR] 로또 번호는 중복돼서는 안됩니다.";
    public static String NOT_VALID_DELIMITER = "[ERROR] 컴마(,)를 제외한 구분자는 불가능합니다.";
    public static String PLACE_BETWEEN_MARGINS = "[ERROR] 컴마(,) 앞이나 뒤에 공백이 있어서는 안됩니다.";
    public static String START_OR_END_WITH_DELIMITER = "[ERROR] 컴마(,)로 시작할 수 없습니다.";
    public static String HAS_REPEATED_DELIMITER = "[ERROR] 컴마(,)가 연속으로 나올 수 없습니다.";

    private ErrorMessage(){}
}
