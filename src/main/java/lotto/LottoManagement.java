package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoManagement {
    private int verifiedMoney;
    private int bonusNumber;
    List<Integer> winningLottoNumbers;

    LottoManagement(){}

    void initMoney(){
        String moneyInput = Console.readLine();
        InputMoneyHandler inputMoneyHandler = new InputMoneyHandler(moneyInput);
        verifiedMoney=inputMoneyHandler.exceptionHandledMoney();
    }

    void initWinningLottoNumbers(){
        String numbersInput = Console.readLine();
        String bonusNumberInput=Console.readLine();
        NumbersHandler numbersHandler = new NumbersHandler(numbersInput,bonusNumberInput);
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
