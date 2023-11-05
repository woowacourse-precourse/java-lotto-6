package lotto.input;

public class InputProcessor {
    private final InputProvider inputProvider;

    public InputProcessor(InputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    public Integer getUserPurchaseMoney() {
        String input = inputProvider.read();
        validatePurchaseMoneyInput(input);
        return Integer.valueOf(input);
    }

    private void validatePurchaseMoneyInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException("정수를 입력해주십시오.");
        }
        if (!isMultipleOfUnit(Integer.parseInt(input))) {
            throw new IllegalArgumentException("최소 단위는 ~입니다.");
        }
    }

    private boolean isMultipleOfUnit(int input) {
        return input % 1000 == 0;
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
