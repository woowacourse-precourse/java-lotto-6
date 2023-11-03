package lotto;

import lotto.domain.InputAmount;
import lotto.view.PrintView;

public class Application {
    static final PrintView printView = new PrintView();
    static final InputAmount inputAmount = new InputAmount();
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printView.Input_Lotto_Buy();
        inputAmount.Input_Lotto_Amount();
    }



}
