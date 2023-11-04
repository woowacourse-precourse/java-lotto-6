package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.MoneyConverter;
import lotto.domain.LottoWinNumbers;
import lotto.util.Status;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView;
    OutputView outputView;
    MoneyConverter moneyConverter;
    LottoGenerator lottoGenerator;
    LottoWinNumbers lottoWinNumbers;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        GameInit();
    }

    public void GameInit() {
        moneyConvertLotto();
        showChances();
        setLottoGenerator();
        showGeneratedLotto();
        setWinLottoNumbers();
    }

    public void moneyConvertLotto() {
        Status status = Status.FAIL;

        while (status == Status.FAIL) {
            try {
                moneyConverter = new MoneyConverter(inputView.inputMoney());
                status = Status.SUCCESS;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public void setLottoGenerator() {
        lottoGenerator = new LottoGenerator(moneyConverter.getChance());
    }

    public void showChances() {
        outputView.printChances(moneyConverter.getChance());
    }

    public void showGeneratedLotto() {
        outputView.printLotto(lottoGenerator.getMyLotto());
    }

    public void setWinLottoNumbers(){
        Status status = Status.FAIL;

        while (status == Status.FAIL) {
            try {
                lottoWinNumbers = new LottoWinNumbers(inputView.inputLottoWin());
                status = Status.SUCCESS;
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

}
