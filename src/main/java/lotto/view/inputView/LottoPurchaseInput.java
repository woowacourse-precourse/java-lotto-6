package lotto.view.inputView;
import camp.nextstep.edu.missionutils.Console;


public class LottoPurchaseInput {

    public int requestPurchaseAmount() {
        while (true) {
            try {
                System.out.println("로또 구매 금액을 입력해주세요");
                String input = Console.readLine();
                return validatePurchaseAmount(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR]올바른 숫자를 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validatePurchaseAmount(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR]입력값이 비어있습니다. 다시 입력해주세요.");
        }
        int parsedAmount = Integer.parseInt(input);
        if (parsedAmount <= 0) {
            throw new IllegalArgumentException("[ERROR]구매 금액은 0원보다 커야 합니다. 다시 입력해주세요.");
        }
        if (parsedAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]로또 구매 금액은 1000원 단위로 입력해야 합니다. 다시 입력해주세요.");
        }
        return parsedAmount;
    }
}
