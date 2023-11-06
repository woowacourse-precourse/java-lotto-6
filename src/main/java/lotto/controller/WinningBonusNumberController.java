package lotto.controller;

import lotto.manager.AppManager;
import lotto.manager.IOManager;
import lotto.manager.LottoManager;

public class WinningBonusNumberController {

    private final AppManager appManager = new AppManager();
    private final LottoManager lottoManager = LottoManager.getInstance();
    private final IOManager ioManager = new IOManager();

    public void handle() {

        ioManager.printWinningBonusNumberInputGuide();

        try {
            int winningBonusNumber = ioManager.readWinningBonusNumber();
            lottoManager.setBonusNumber(winningBonusNumber);
        } catch(IllegalArgumentException e) {
            ioManager.printExceptionMessage(e.getMessage());
            String className = this.getClass().getName();
            appManager.handleInvalidInput(className);
        }

    }
}
