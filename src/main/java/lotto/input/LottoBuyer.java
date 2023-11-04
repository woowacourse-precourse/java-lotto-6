package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.ApplicationContext;
import lotto.controller.LottoController;

public class LottoBuyer {
    private LottoController lottoController = ApplicationContext.getController();

    public void gernerateTicket(){
        int wallet = Integer.parseInt(readLine());
        lottoController.gernerateTicket(wallet);
    }

    public void verifyWinRecord(){
        lottoController.verifyWinRecord();
    }

    public void verifyReturns(){
        lottoController.verifyReturns();
    }

}
