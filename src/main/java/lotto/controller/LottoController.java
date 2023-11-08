package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.LottoUi;

public class LottoController {
    private LottoUi lottoUi;
    private LottoService lottoService;

    public LottoController() {
        lottoUi = new LottoUi();
        lottoService = new LottoService();
    }

    public void run() {
        askMoney();
        createLottosByMoney();
        askWinNumbers();
        askBonusNumber();
        getResult();
    }

    private void askMoney() {
        lottoUi.printMoneyInput();
        boolean isDone = false;
        while (!isDone) {
            try {
                lottoService.setMoney(lottoUi.readInt());
                isDone = true;
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }
        }
    }

    private void createLottosByMoney() {
        lottoUi.printCountOutput(lottoService.getCount());
        List<Lotto> lottos = lottoService.createLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }

    private void askWinNumbers() {
        lottoUi.printWinningNumberInput();
        boolean isDone = false;
        while (!isDone) {
            try {
                lottoService.setWinNumbers(lottoUi.readInts());
                isDone = true;
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }
        }
    }

    private void askBonusNumber() {
        lottoUi.printBonusNumberInput();
        boolean isDone = false;
        while (!isDone) {
            try {
                lottoService.setBonusNumber(lottoUi.readInt());
                isDone = true;
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex);
            }
        }
    }

    private void getResult() {
        lottoUi.printResultOutput();
        lottoUi.printStatistics(lottoService.compareLottos());
        lottoUi.printTotalProfit(lottoService.calcTotalWinningMoney(), lottoService.getMoney());
    }
}
