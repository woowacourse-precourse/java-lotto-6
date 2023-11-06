package lotto.View;

public class ExceptionMessages {

    private final static String INVALID_TYPE_MESSAGE = "[ERROR] 숫자로 이루어진 값을 입력해주세요";
    public static void invalidTypeError()
    {
        System.out.println(INVALID_TYPE_MESSAGE);
    }

    public static void invalidInputEroor()
    {
        System.out.println("[ERROR]");
    }
}
