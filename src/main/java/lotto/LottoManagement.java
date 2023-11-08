package lotto;
import camp.nextstep.edu.missionutils.Console;

public class LottoManagement {
    private int verifiedMoney;

    LottoManagement(){}

    void initMoney(){
        String moneyInput = Console.readLine();
        InputMoneyHandler inputMoneyHandler = new InputMoneyHandler(moneyInput);
        verifiedMoney=inputMoneyHandler.exceptionHandledMoney();
    }

    public int getMoney(){
        return verifiedMoney;
    }

}
