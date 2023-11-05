package lotto;

import lotto.view.AmountInputView;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView<Integer> amountInputView = new AmountInputView<>(Integer::parseInt);
        int amount = amountInputView.getInput();
        System.out.println(amount);
    }
}
