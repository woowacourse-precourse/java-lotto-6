package lotto.validator;

public class InputValidator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 에러 체크를 사용하는 로직에서는 IllegalArgumentException이 감지되면 해당 로직을 다시 실행하도록 설계 필요

    public boolean validateInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

    public boolean validateInputData(int amount, int unit) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return true;
    }

}
