package lotto;

public class ErrorMessage {
    private static final String TYPE_ERROR = "숫자만 입력 가능합니다.";

    public static void setTypeError() {
        System.out.print(TYPE_ERROR);
    }
}
