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
        makeRandomLotto(inPutMoney());

        //랜덤 로또 생성
            //랜덤 로또 생성
            //중간 로또 출력
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

    private void makeRandomLotto(Money money){
        int purchasedLottoCount = money.getPurchaseAmount();

        RandomLottoMachine randomLottoMachine =
                new RandomLottoMachine(purchasedLottoCount);

        randomLottoMachine.getRandomLottoList();



    }
}
