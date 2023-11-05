package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.ApplicationContext;
import lotto.controller.LottoController;

public class LottoDrawer {
    private LottoController lottoController = ApplicationContext.getController();

    public void inputLotto(){
        String lottoNumber = readLine();
        String bonusNumber = readLine();
        lottoController.inputLotto(lottoNumber, bonusNumber);
    }

    public void compareWinning(){
        lottoController.compareWinning();
    }
}
