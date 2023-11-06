package lotto.controller;

import lotto.manager.AppManager;
import lotto.manager.IOManager;
import lotto.manager.LottoManager;

import java.util.List;

public class WinningNumberController {

    private final AppManager appManager = new AppManager();
    private final LottoManager lottoManager = LottoManager.getInstance();
    private final IOManager ioManager = new IOManager();

    public void handle() {

        ioManager.printWiningNumberInputGuide();

        try {
            List<Integer> winningNumber = ioManager.readWinningNumber();
            lottoManager.setWinningNumber(winningNumber);
        } catch (IllegalArgumentException e ) {
            ioManager.printExceptionMessage(e.getMessage());
            String className = this.getClass().getName();
            appManager.handleInvalidInput(className);
        }
    }
}
