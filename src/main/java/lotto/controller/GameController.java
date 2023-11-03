package lotto.controller;

import lotto.domain.LottoGameCalculator;
import lotto.domain.LottoGenerator;
import lotto.domain.MoneyConverter;
import lotto.util.Status;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView;
    OutputView outputView;
    MoneyConverter moneyConverter;
    LottoGenerator lottoGenerator;
    LottoGameCalculator lottoGameManager;



    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        moneyConvertLotto();
        showChances();
    }

    public void moneyConvertLotto() {
        Status status = Status.FAIL;

        while (status == Status.FAIL) {
            try {
                moneyConverter = new MoneyConverter(inputView.inputMoney());
                status = Status.SUCCESS;
            }catch (IllegalArgumentException ignored){}
        }
    }

    public void showChances(){
        outputView.printChances(moneyConverter.getChance());
    }

}
