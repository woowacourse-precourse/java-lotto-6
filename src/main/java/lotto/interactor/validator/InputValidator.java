package lotto.interactor.validator;

public class InputValidator extends IllegalArgumentException{
    public static void checkNumericFormat(String input) throws IllegalArgumentException {
        if (!input.matches("\\d+")) {
            System.out.println("[ERROR] 입력 형식이 잘못되었습니다.");
            throw new IllegalArgumentException();
        }
    }
    public static void checkDivisibleByThousand(String input) throws IllegalArgumentException {
        int amount = Integer.parseInt(input);
        if (amount % 1000 != 0) {
            System.out.println("[ERROR] 천원 단위의 돈을 입력하세요.");
            throw new IllegalArgumentException();
        }
    }
}
