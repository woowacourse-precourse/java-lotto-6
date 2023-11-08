package lotto.view;

public class ExceptionMessage {
    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private static final String NOT_IN_RANGE = EXCEPTION_HEADER+"숫자는 1부터 45사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER_SIZE = EXCEPTION_HEADER +"당첨 번호는 6개 입력 가능합니다.";
    private static final String DUPLICATE_NUMBER = EXCEPTION_HEADER + "중복된 숫자를 입력하셨습니다.";
    private static final String INPUT_TYPE_ERROR = EXCEPTION_HEADER + "숫자만 입력해주세요.";
    private static final String NUMBER_IS_NOT_NATURAL = EXCEPTION_HEADER + "금액은 0 이상의 숫자이어야 합니다.";
    private static final String NOT_DIVISIBLE_NUMBER = EXCEPTION_HEADER + "금액은 1,000 단위여야 합니다.";

    public static void rangeException(){
        System.out.println(NOT_IN_RANGE);
    }
    public static void sizeException(){
        System.out.println(NOT_NUMBER_SIZE);
    }
    public static void duplicateException(){
        System.out.println(DUPLICATE_NUMBER);
    }
    public static void inputTypeException(){
        System.out.println(INPUT_TYPE_ERROR);
    }
    public static void naturalException(){
        System.out.println(NUMBER_IS_NOT_NATURAL);
    }
    public static void divisibleException(){
        System.out.println(NOT_DIVISIBLE_NUMBER);
    }
}
