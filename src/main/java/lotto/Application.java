package lotto;

import static lotto.Notice.*;

public class Application {
    public static void main(String[] args) {

        View.printMessage(ASK_BUDGET);
        String LottoBudgetInput = View.getUserInput();
        System.out.println("LottoBudgetInput = " + LottoBudgetInput);
    }

}
