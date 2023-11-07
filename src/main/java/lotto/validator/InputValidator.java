package lotto.validator;

public class InputValidator {

    public static void validateBudget(String inputBudget) {

        try {
            int budget = Integer.parseInt(inputBudget);

            if (budget % 1000 != 0) {
                throw new IllegalArgumentException("1000 원으로 나누어 떨어지지 않는 구입금액 입니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 형식의 구입금액 입니다.");
        }
    }

}
