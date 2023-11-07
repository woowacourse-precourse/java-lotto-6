package lotto.interactor.validator;

public class InputValidator {
    public static void checkNumericFormat(String input) throws IllegalArgumentException {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
        }
    }
    public static void checkDivisibleByThousand(String input) throws IllegalArgumentException {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("천원 단위의 돈을 입력하세요.");
        }
    }
}
