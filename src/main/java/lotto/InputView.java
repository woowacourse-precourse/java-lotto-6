package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String ASK_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public int askPrice() {
        askHowManyPurchase(ASK_PURCHASE_MESSAGE);
        String input = Console.readLine();
        validateBlankAndEmptyInteger(input);
        return validateZero(validateNegativeInteger(validateInteger(input)));
    }

    private void askHowManyPurchase(String askPurchaseMessage) {
        System.out.println(askPurchaseMessage);
    }

    public int validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            askHowManyPurchase("[ERROR] 정수 외에는 입력받을 수 없습니다.");
        }

        return Integer.parseInt(input);
    }

    public void validateBlankAndEmptyInteger(String input) {
        if (input.isBlank() || input.isEmpty() || input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다.");
        }
    }

    public int validateNegativeInteger(int input) {
        if (input < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력받을 수 없습니다.");
        }

        return input;
    }

    public int validateZero(int input) {
        if (input == 0) {
            throw new IllegalArgumentException("[ERROR] 0은 입력받을 수 없습니다.");
        }

        return input;
    }
}
