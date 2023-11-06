package lotto;

public class Validator {
    private static final String NULL_ERROR_MESSAGE = "입력값이 null 일 수 없습니다.";
    private static final String BLANK_ERROR_MESSAGE = "입력값은 빈 값일 수 없습니다.";

    private static final Validator instance = new Validator();

    public static Validator getInstance(){
        return instance;
    }

    private Validator() {
    }

    public void validateLottoMoney(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }

        if (input.isBlank())  { // "", " " : true
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }
}