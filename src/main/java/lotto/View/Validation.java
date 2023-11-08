package lotto.View;

public class Validation {


    private static final String PURCHASE_SUM_INPUT_EXCEPTION_MESSAGE = "[ERROR]: 구입금액은 1000원 단위로 나누어 떨어져야 합니다. 올바른 값을 다시 입력해 주십시오.\n";
    private static final String BLANK_INPUT_EXCEPTION_MESSAGE = "[ERROR]: 공백이 입력되었습니다. 올바를 번호를 다시 입력해 주십시오.\n";
    private static final String NOT_IN_LOTTO_NUMBER_RANGE_EXCEPTION = "[ERROR]: 로또 번호의 숫자 범위는 1~45까지입니다. 올바른 번호를 입력해주십시오.\n";
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "[ERROR]: 숫자가 아닌 값이 입력되었습니다. 올바른 수를 입력해주십시오.\n";
    private static final String NOT_IN_RANGE_EXCEPTION_MESSAGE = "[ERROR]: 입력 가능한 범위를 넘어선 숫자가 입력되었습니다. Integer범위 내의 올바른 수를 입력해 주십시오.\n";


    public static void checkNotNumber(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            OutputView.printInputException(NOT_NUMBER_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void checkNotInteger(String input){
        Integer number = Integer.parseInt(input);
        if (number <= 0) {
            OutputView.printInputException(NOT_IN_RANGE_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public static void checkNotDivided(String input){
        Integer number = Integer.parseInt(input);

        if(number % 1000 != 0){
            OutputView.printInputMessage(PURCHASE_SUM_INPUT_EXCEPTION_MESSAGE);
            throw new IllegalArgumentException();

        }
    }


}
