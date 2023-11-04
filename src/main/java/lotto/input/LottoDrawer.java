package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.ApplicationContext;
import lotto.controller.LottoController;

public class LottoDrawer {
    private LottoController lottoController = ApplicationContext.getController();

    public void drawNumber(){
        int winNumbers = Integer.parseInt(readLine());
        int bonusNumber = Integer.parseInt(readLine());
        lottoController.drawNumber();
    }
}
