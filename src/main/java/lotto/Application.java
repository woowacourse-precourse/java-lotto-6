package lotto;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = purchaseAmountInput();
    }

    public static int purchaseAmountInput() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = InputManager.receiveUserInput();
        
        InputValidator.validateIsNumeric(input);
        int purchaseAmount = Integer.parseInt(input);
        InputValidator.validateDivision1000(purchaseAmount);
        
        return purchaseAmount / 1000;
    }

}
