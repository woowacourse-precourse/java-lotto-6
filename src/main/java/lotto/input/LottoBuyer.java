package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.ApplicationContext;
import lotto.controller.LottoController;
import lotto.input.convert.ConverToInt;

public class LottoBuyer {
    private LottoController lottoController = ApplicationContext.getController();

    public void gernerateTicket(){
        ConverToInt converToInt = ConverToInt.from(readLine());
        int wallet = converToInt.getValue();

        lottoController.gernerateTicket(wallet);
    }

    public void verifyWinRecord(){
        lottoController.verifyWinRecord();
    }

    public void verifyReturns(){
        lottoController.verifyReturns();
    }

}
