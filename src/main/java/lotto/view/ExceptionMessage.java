package lotto.view;


public class ExceptionMessage {
    private static final String INPUT_MUST_NUMBER ="숫자를 입력해 주세요";
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_MUST_NATURAL_NUMBER ="자연수를 입력해 주세요";
    private static final String INPUT_MUST_DIVISIBLE_NUMBER ="1000단위의 수를 입력해 주세요";
    private static final String INVALID_NUMBER_RANGE ="로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    private static final String OVERLAP_NUMBER_ERROR ="중복된 숫자를 입력하였습니다.";

    private static final String INPUT_SIZE_ERROR ="6개의 숫자를 입력해 주세요.";


    public static void errorMessage(){
        System.out.print(ERROR_MESSAGE);
    }

    public static void inputMustNumber(){
        System.out.println(INPUT_MUST_NUMBER);
    }

    public static void InputMustNaturalNumber(){
        System.out.println(INPUT_MUST_NATURAL_NUMBER);
    }

    public static void InputMustDivisibleNumber(){
        System.out.println(INPUT_MUST_DIVISIBLE_NUMBER);
    }

    public static void invalidNumberRange(){System.out.println(INVALID_NUMBER_RANGE);}

    public static void overlapNumberError(){System.out.println(OVERLAP_NUMBER_ERROR);}

    public static void InputSizeError(){System.out.println(INPUT_SIZE_ERROR);}

}
