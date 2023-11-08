package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.CompareNumber;
import lotto.service.GenerateLotto;


public class LottoController {

    private final UserController userController = new UserController();
    private final GenerateLotto generateLotto = new GenerateLotto();
    private final CompareNumber compareNumber = new CompareNumber();


    public void start() {
        HashMap<Integer, Integer> sameMap = new HashMap<>();
        HashMap<Integer, Boolean> bonusMap = new HashMap<>();
        int money = userController.requestMoney();
        int amount = amountLotto(money);
        List<Lotto> lottoList = generateLotto.generateLottoList(amount);
        List<Integer> winningNumber = userController.requestWinningNumber();
        int bonusNumber = userController.requestBonusNumber();
        int index = 0;
        for (Lotto lotto : lottoList) {
            int count;
            if ((count = compareNumber.CompareLotto(lotto.getNumbers(), winningNumber))>0)
                sameMap.put(index, count);
            if (compareNumber.CompareBonuseLotto(bonusNumber, lotto.getNumbers()))
                bonusMap.put(index, true);
            index++;
        }
    }

    public int amountLotto(int money) {
        return money / 1000;
    }


}