package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final static String ASK_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String ASK_BONUS_WINNING_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int askPrice() {
        askHowManyPurchase();
        String input = Console.readLine();
        validateBlankAndEmptyInteger(input);
        return validateNegativeIntegerAndZero(validateInteger(input));
    }

    public void askWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
    }

    public void askBonusWinningNumber() {
        System.out.println(ASK_BONUS_WINNING_NUMBER_MESSAGE);
    }

    private void askHowManyPurchase() {
        System.out.println(ASK_PURCHASE_MESSAGE);
    }

    public int validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 정수 외에는 입력받을 수 없습니다.");
        }
        return Integer.parseInt(input);
    }

    public void validateBlankAndEmptyInteger(String input) {
        if (input.isBlank() || input.isEmpty() || input.contains(" ")) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력될 수 없습니다.");
        }
    }

    public int validateNegativeIntegerAndZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 값은 입력받을 수 없습니다.");
        }
        return input;
    }
}
