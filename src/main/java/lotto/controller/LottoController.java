package lotto.controller;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.support.RandomLotto;
import lotto.util.InputManager;
import lotto.util.OutputManager;

import java.util.List;


public class LottoController {

    private static final LottoService lottoService = new LottoService();
    private static final RandomLotto randomLotto = new RandomLotto();

    private static final InputManager inputManager = new InputManager();

    public void execute() {

        Long lottoTimes = BuyLotto();
        List<Lotto> lottos = randomLotto.RandomLottos(lottoTimes);
        WinningLotto winningLotto = setWinningNumbers();

        lottoService.execute(lottos, winningLotto);
    }


    private WinningLotto setWinningNumbers() {
        WinningLotto winningLotto = null;
        try {
            List<Integer> winning = inputManager.getWinningNumbers();
            String bonusNumber = inputManager.getBonus();
            winningLotto = new WinningLotto(winning, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputManager.PRINT_WRONG();
            setWinningNumbers();
        }
        return winningLotto;
    }


    private Long BuyLotto() {
        Customer customer = null;
        try {
            String stringMoney = inputManager.getMoney();
            customer = new Customer(stringMoney);
            OutputManager.BUY_PRINT(customer.getCount());
        } catch (IllegalArgumentException e) {
            OutputManager.PRINT_WRONG();
            BuyLotto();
        }
        return customer.getCount();
    }


}
