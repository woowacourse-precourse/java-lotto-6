package lotto.controller;

import lotto.NumberGenerator;
import lotto.message.ConsoleMessage;
import lotto.message.ExceptionMessage;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final NumberGenerator numberGenerator;

    public Controller(){
       this.numberGenerator = new RandomNumberGenerator();
    }

    public void run(){

        String mymoney = InputView.inputMoney();
        validateParseInt(mymoney);
        validateThousandMultiple(Integer.parseInt(mymoney));
        Trial trial = new Trial(Integer.parseInt(mymoney));
        System.out.printf(ConsoleMessage.PURCHASE_LOTTO.getMessage()+ "\n", trial.getTrial());

        List<Lotto> userLottoList = new ArrayList<>();
        UserLottoGenerator userLottoGenerator = new UserLottoGenerator(numberGenerator, trial.getTrial(), userLottoList);
        userLottoList = userLottoGenerator.makeLottoList();
        printUserNumber(userLottoList);

        Lotto answerNumber = new Lotto(InputView.inputNumbers());
        int bonusNumber = InputView.inputBonusNumber();

        LottoNumberChecker lottoNumberChecker = new LottoNumberChecker(answerNumber.getNumbers(), userLottoList, bonusNumber);
        List<Integer> rankList = lottoNumberChecker.getRankList();
        WinningMoney winningMoney = new WinningMoney(rankList);

        OutputView.printWinningStat(rankList);
        RateOfReturn rateOfReturn = new RateOfReturn(winningMoney.getWinningMoney(), Integer.parseInt(mymoney));
        OutputView.printRateOfReturn(rateOfReturn.getReturnOfRate());
    }

    private void printUserNumber(List<Lotto> userLottoList){
        for(Lotto userNumber : userLottoList){
            OutputView.printLottoNumber(userNumber.getNumbers());
        }
    }

    private void validateParseInt(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.NOT_NUMBER.getMessage());
            InputView.inputMoney();
        }
    }

    private void validateThousandMultiple(int money) {
        if ((money % 1000) != 0) {
            System.out.println(ExceptionMessage.NOT_THOUSAND.getMessage());
            InputView.inputMoney();
        }
    }
}
