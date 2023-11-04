package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.RandomLotto;
import lotto.domain.RandomLottoMachine;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class MainLottoController {
    Input input = new Input();
    Money money;

    public void startLotto() {
        RandomLotto randomLotto = makeRandomLotto(inPutMoney()); //분리해야될듯 money가 갹체가 되어야하
        sendRandomLottoDataToView(randomLotto.getRandomLottoNumbers());

        ///////

        //로또 입력받기
        //결과 출력

    }

    private Money inPutMoney() {
        try {
            return new Money(input.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inPutMoney();
        }
    }

    private RandomLotto makeRandomLotto(Money money) {
        int purchasedLottoCount = money.getPurchaseAmount();
        RandomLottoMachine randomLottoMachine = //얘가 정적이 되어야하네...
                new RandomLottoMachine(purchasedLottoCount);
        try {
            return new RandomLotto(randomLottoMachine.getRandomLottoList());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[Error]");
        }
    }

    private void sendRandomLottoDataToView(List<Lotto> lottos) { //RandomLotto lottos?
        Output.printPurchasedLottoCount(lottos.size());
        for (Lotto lotto : lottos) {
            Output.printPurchasedLottoList(lotto.getNumbers());
        }
    }

}
