package lotto;

public class Error {
    public enum ErrorType{
        INVALID_AMOUNT,
        INVALID_INPUT_TYPE,
        INVALID_LOTTO_INPUT,
        DUPLICATION
    }

    public static void errorMessage(ErrorType errorType) {
        if (errorType == ErrorType.INVALID_AMOUNT) {
            System.out.println("[ERROR] 입력값에러");
            throw new IllegalArgumentException();
        } else if (errorType == ErrorType.INVALID_INPUT_TYPE) {
            System.out.println("[ERROR] 입력타입에러");
            throw new IllegalArgumentException();
        } else if (errorType == ErrorType.INVALID_LOTTO_INPUT) {
            System.out.println("[ERROR] 로또 값 에러");
            throw new IllegalArgumentException();
        } else if (errorType == ErrorType.DUPLICATION) {
            System.out.println("[ERROR] 중복 에러");
            throw new IllegalArgumentException();
        }
    }

}
