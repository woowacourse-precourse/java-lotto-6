package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.model.Money.MONEY_UNIT;

public class MainController {

    private InputView inputview;
    private OutputView outputView;

    public MainController(){
        this.inputview = new InputView();
        this.outputView = new OutputView();
    }
    public void start(){
        Money money = inputview.inputMoneyInfo();
        Lotto lotto = inputview.answerLottoInfo();
        BonusNumber bonusNumber = inputview.bonusNumberInfo(lotto.getNumbers());


    }

}
