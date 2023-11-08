package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.GenerateLotto;


public class LottoController {

    private final UserController userController = new UserController();
    private final GenerateLotto generateLotto = new GenerateLotto();

    public void start() {
        int money = userController.requestMoney();
        int amount = amountLotto(money);
        List<Lotto> lotto = generateLotto.generateLottoList(amount);
        List<Integer> winningNumber = userController.requestWinningNumber();
    }

    public int amountLotto(int money) {
        return money / 1000;
    }


}