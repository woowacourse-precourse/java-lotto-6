package lotto;

import java.util.List;

public class LottoManagement {
    private int verifiedMoney;
    private int bonusNumber;
    List<Integer> winningLottoNumbers;

    LottoManagement(){}

    void initMoney(){
        InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
        inputMoneyHandler.init();
        verifiedMoney=inputMoneyHandler.exceptionHandledMoney();
    }

    void initWinningLottoNumbers(){

        NumbersHandler numbersHandler = new NumbersHandler();
        numbersHandler.init();
        winningLottoNumbers = numbersHandler.convertedWinningNumbers();
        bonusNumber=numbersHandler.convertedBounsNumber();
    }

    public int getMoney(){
        return verifiedMoney;
    }
    public int getBonusNumber(){
        return bonusNumber;
    }

}
