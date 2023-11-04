package lotto;

import lotto.domain.InputAmount;
import lotto.view.PrintView;

public class Application {
    private static InputAmount inputAmount;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int Buy_Ticket = Input_Lotto_Buy();
    }

    public static int Input_Lotto_Buy(){
        inputAmount = new InputAmount(PrintView.Input_Lotto_Buy());
    }

}
