package lotto.Controller;

import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private int money = 0;

    public void run() {
        receiveMoney();
    }
    private void receiveMoney() {
        try {
            outputView.printGetMoney();
            money = Integer.parseInt(inputView.getMoney());
        }
        catch(NumberFormatException e){
            System.out.println("[ERROR] 잘못된 입력입니다.");
            receiveMoney();
        }
    }
}
