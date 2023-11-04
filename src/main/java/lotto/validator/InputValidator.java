package lotto.validator;

public class InputValidator {
    private static final String ERROR_MESSAGE = "[ERROR]";

    // 에러 체크를 사용하는 로직에서는 IllegalArgumentException이 감지되면 해당 로직을 다시 실행하도록 설계 필요

    public void validateInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
        } finally {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputData(int amount, int unit) {
        try {
            validateAmount(amount, unit);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
        } finally {
            throw new IllegalArgumentException();
        }
    }

    public IllegalArgumentException validateAmount(int amount, int unit) {
        if (amount % unit != 0) {
            return new IllegalArgumentException();
        }
        return null;
    }

}
