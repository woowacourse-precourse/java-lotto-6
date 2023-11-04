package view;

public class ExceptionMessage {
    private static final String NOT_NUMBER_SIZE = "[ERROR] 당첨 번호는 6개 입력 가능합니다.";
    private static final String NOT_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String NOT_NUMBER_UNIQUE = "[ERROR] 중복된 숫자를 입력하셨습니다.";
    private static final String NOT_CORRECT_TYPE = "[ERROR] 숫자만 입력해 주세요.";
    private static final String NOT_CORRECT_PRICE = "[ERROR] 1000원 단위로 구입금액을 입력해 주세요.";
    private static final String NOT_POSITIVE_PRICE = "[ERROR] 0 이상의 금액을 입력해 주세요.";

    public static void sizeException() {
        System.out.println(NOT_NUMBER_SIZE);
    }

    public static void rangeException() {
        System.out.println(NOT_NUMBER_RANGE);
    }

    public static void uniqueException() {
        System.out.println(NOT_NUMBER_UNIQUE);
    }

    public static void typeException(){
        System.out.println(NOT_CORRECT_TYPE);
    }

    public static void priceException(){
        System.out.println(NOT_CORRECT_PRICE);
    }

    public static void positiveException(){
        System.out.println(NOT_POSITIVE_PRICE);
    }
}
