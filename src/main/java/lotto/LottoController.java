package lotto;

import java.util.HashMap;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void playGame() {
        Money money = requestMoney();
        int count = lottoService.calculateCount(money.getMoney());
        HashMap<Integer, Lotto> lotties = lottoService.makeLotto(count);
    }

    public Money requestMoney(){
        try{
            outputView.printMoneyInputMessage();
            Money money = lottoService.changeStringToInt(inputView.getMoney());
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return requestMoney();
    }
}
