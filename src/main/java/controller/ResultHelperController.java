package controller;

import lotto.Lotto;
import model.ProfitCalculable;
import model.LottoJudge;
import view.LottoResultPrinter;
import view.Mainview;

class ResultHelperController {
    private LottoResultPrinter resultPrinter;

    public ResultHelperController(LottoResultPrinter resultPrinter) {
        this.resultPrinter = resultPrinter;
    }

    private int[] processResult(LottoJudge judgeMan, Lotto userLotto, int bonusNumber) {
        int[] result = judgeMan.judgeLotto(userLotto, bonusNumber);
        resultPrinter.printHowManyAndLottos(judgeMan.getComputerLottos());
        resultPrinter.printresult(result);
        return result;
    }

    private int getProfit(ProfitCalculable profitCalculateMan, int[] result) {
        return profitCalculateMan.calculateProfit(result);
    }

    private void processRateofProfit(ProfitCalculable rateCalculateMan, int money, int profit) {
        String rateOfProfit = rateCalculateMan.calculateRateOfProfit(String.valueOf(money), profit);
        resultPrinter.printRateOfProfit(rateOfProfit);
    }

    void processLottoGame(ProcessLottoGameParameters parameters) {
        int[] result = processResult(parameters.judgeMan(),
                parameters.userLotto(), parameters.bonusNumber());
        processRateofProfit(parameters.rateCalculateMan(), parameters.money(),
                getProfit(parameters.rateCalculateMan(), result));

    }
}
