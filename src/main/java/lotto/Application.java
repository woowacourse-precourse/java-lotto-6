package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = purchaseAmountInput();

        Lotto winningLotto = winningLottoInput();

        System.out.println();
    }

    public static int purchaseAmountInput() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = InputManager.receiveUserInput();
        
        InputValidator.validateIsNumeric(input);
        int purchaseAmount = Integer.parseInt(input);
        InputValidator.validateDivision1000(purchaseAmount);
        
        return purchaseAmount / 1000;
    }

    public static Lotto winningLottoInput() {
        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> winningLotto = InputManager.winningLottoInput();

        return new Lotto(winningLotto);
    }
}
