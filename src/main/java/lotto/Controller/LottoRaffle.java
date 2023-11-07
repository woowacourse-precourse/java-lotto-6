package lotto.Controller;

import lotto.Domain.BonusNumber;
import lotto.Domain.LottoPapers;
import lotto.Domain.WinningCalculator;
import lotto.Util.Converter;
import lotto.Domain.Lotto;
import lotto.Domain.LottoAmount;
import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoRaffle {
    LottoAmount lottoAmount = new LottoAmount();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Converter converter = new Converter();
    WinningCalculator winningCalculator = new WinningCalculator();
    Lotto lotto;
    private BonusNumber bonusNumber;
    private LottoPapers lottoPapers;
    private int amount;

    public void run(){
        inputBuyAmount();
        maikingLottoPapers();
        outputLottoPapers();
        inputWinningNumber();
        inputBonusNumber();
        outputWinningCount();
        outputROI();
    }
    private void outputWinningCount(){
        winningCalculator.calculateMatchNumbers(lottoPapers.getLottoPapers()
                , lotto.getNumbers(), bonusNumber.getBonusNumber());
        outputView.printWinningCount(winningCalculator.getWinningCount());
    }

    private void outputROI(){
        outputView.printROI(winningCalculator.calculateROI(amount));
    }
    private void inputBuyAmount(){
        try {
            amount = lottoAmount.initLottoAmount(converter.convertNumber(inputView.printLottoAmount()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBuyAmount();
        }
    }

    private void maikingLottoPapers(){
        this.lottoPapers = new LottoPapers(amount);
    }

    private void outputLottoPapers(){
        outputView.printBuyMessage(amount, lottoPapers.getLottoPapers());
    }

    private void inputWinningNumber(){
        try {
            lotto = new Lotto(converter.convertLotto(inputView.printInputWinningNumber()));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputWinningNumber();
        }
    }

    private void inputBonusNumber(){
        try {
            bonusNumber = new BonusNumber(converter.convertNumber(inputView.printInputBonusNumber())
                    , lotto.getNumbers());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            inputBonusNumber();
        }
    }
}
