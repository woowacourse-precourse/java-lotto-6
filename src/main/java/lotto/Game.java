package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private int AMOUNT;
    private InputView inputView;
    private OutputView outputView;

    public Game() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run(){
        inputView.purchaseAmountView();
        AMOUNT = purchaseAmountInput();

        outputView.purchasesNumberView(AMOUNT);
        
    }

    public int purchaseAmountInput(){
        //예외 처리 추가해야 함

        return Integer.parseInt(Console.readLine());
    }

}
