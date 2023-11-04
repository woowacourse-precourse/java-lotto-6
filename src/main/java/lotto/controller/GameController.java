package lotto.controller;

import lotto.domain.*;
import lotto.util.Status;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {
    InputView inputView;
    OutputView outputView;
    MoneyConverter moneyConverter;
    LottoGenerator lottoGenerator;
    LottoWinNumbers lottoWinNumbers;
    LottoBonusNumber lottoBonusNumber;
    LottoCountCalculator lottoCountCalculator;
    LottoProfitCalculator lottoProfitCalculator;

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
        setLottoBonusNumber();
        setLottoCountCalculator();
        setLottoProfitCalculator();
    }

    public void moneyConvertLotto() {
        Status status = Status.FAIL;

        while (status == Status.FAIL) {
            try {
                moneyConverter = new MoneyConverter(inputView.inputMoney());
                status = Status.SUCCESS;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setLottoBonusNumber(){
        Status status = Status.FAIL;

        while (status == Status.FAIL) {
            try {
                lottoBonusNumber = new LottoBonusNumber(inputView.inputLottoWin());
                status = Status.SUCCESS;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void setLottoCountCalculator(){
        lottoCountCalculator = new LottoCountCalculator(
                lottoGenerator.getMyLotto(),
                lottoWinNumbers.getLottoWinNumbers(),
                lottoBonusNumber.getBonusNumber()
        );
    }

    public void setLottoProfitCalculator(){
        lottoProfitCalculator = new LottoProfitCalculator(
                lottoCountCalculator.getLottoResult(),
                moneyConverter.getChance());
    }
}
