package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.ApplicationContext;
import lotto.controller.LottoController;

public class LottoBuyer {
    private LottoController lottoController = ApplicationContext.getController();

    public void gernerateLotto(){
        int wallet = Integer.parseInt(readLine());
        lottoController.gernerateLotto(wallet);
    }

    public void verifyWinRecord(){
        lottoController.verifyWinRecord();
    }

    public void verifyReturns(){
        lottoController.verifyReturns();
    }

}
