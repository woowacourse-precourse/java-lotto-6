package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class MainLottoController {
    Input input = new Input();
    Money money;

    public void startLotto() {
        RandomLotto randomLotto = makeRandomLotto(inPutMoney()); //분리해야될듯 money가 갹체가 되어야하
        sendRandomLottoDataToView(randomLotto.getRandomLottoNumbers());

        UserLotto userLotto = makeUserLotto();



        //결과 출력

    }

    //region 램덤로또
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
    //endregion

    //region 로또번호 입력받기
    private UserLotto makeUserLotto() {
        Lotto mainNumber = inputMainLottoNumber();
        BonusLotto bonusNumber = inputBonusLottoNumber();
        try{
            return new UserLotto(mainNumber,bonusNumber);
        }catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return makeUserLotto();
        }
    }

    private Lotto inputMainLottoNumber() {
        try {
            return new Lotto(input.getMainLottoNumber());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputMainLottoNumber();
        }
    }
    private BonusLotto inputBonusLottoNumber(){
        try {
            return new BonusLotto(input.getBonusNumber());
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return inputBonusLottoNumber();
        }
    }
    //endregion


}
