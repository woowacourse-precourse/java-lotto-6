package lotto.controller;

import lotto.domain.Money;
import lotto.view.Input;
import lotto.view.Output;

public class MainLottoController {
    Input input = new Input();
    Money money;

    public void startLotto() {
        inPutMoney();
        //랜덤 로또 생성
        //중간 로또 출력

    }

    private Money inPutMoney() {
        try {
            return new Money(input.getPurchaseAmount());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inPutMoney();
        }
    }
}
