package lotto.Controller;

import lotto.Constant.LottoConstant;
import lotto.Lottery;
import lotto.View.InputView;

public class LottoController {
    private final InputView inputView;
    private Lottery lottery;

    public LottoController()
    {
        this.inputView = new InputView();
    }

    public void simulateLottery()
    {
        System.out.println("구입금액을 입력해 주세요.");
        int cost = inputView.getCost();

        Lottery lottery = new Lottery(cost);
        System.out.println(lottery.getNumberOfLotto() + "개를 구매했습니다.");
    }
}
