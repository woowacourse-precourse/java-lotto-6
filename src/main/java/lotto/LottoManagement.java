package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class LottoManagement {
    private int verifiedMoney;
    private int bonusNumber;
    List<Integer> winningLottoNumbers;

    LottoManagement(){}

    void initMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String moneyInput = Console.readLine();
        InputMoneyHandler inputMoneyHandler = new InputMoneyHandler(moneyInput);
        verifiedMoney=inputMoneyHandler.exceptionHandledMoney();
    }

    void initWinningLottoNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbersInput = Console.readLine();
        System.out.println("보너스 번호를 입력해주세요:");
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
