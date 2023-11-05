package controller;

import java.util.EnumMap;
import lotto.Lotto;
import model.ProfitCalculable;
import model.LottoJudge;
import model.Rank;
import view.LottoResultPrinter;
import view.Mainview;

class ResultHelperController {
    private LottoResultPrinter resultPrinter;

    public ResultHelperController(LottoResultPrinter resultPrinter) {
        this.resultPrinter = resultPrinter;
    }

    private EnumMap<Rank, Integer> processResult(LottoJudge judgeMan, Lotto userLotto, int bonusNumber) {
        EnumMap<Rank, Integer> result = judgeMan.judgeLotto(userLotto, bonusNumber);
        resultPrinter.printHowManyAndLottos(judgeMan.getComputerLottos());
        resultPrinter.printresult(result);
        return result;
    }

    private int getProfit(ProfitCalculable profitCalculateMan, EnumMap<Rank, Integer> result) {
        return profitCalculateMan.calculateProfit(result);
    }

    private void processRateofProfit(ProfitCalculable rateCalculateMan, int money, int profit) {
        String rateOfProfit = rateCalculateMan.calculateRateOfProfit(String.valueOf(money), profit);
        resultPrinter.printRateOfProfit(rateOfProfit);
    }

    void processLottoGame(ProcessLottoGameParameters parameters) {
        EnumMap<Rank, Integer> result = processResult(parameters.judgeMan(),
                parameters.userLotto(), parameters.bonusNumber());
        processRateofProfit(parameters.rateCalculateMan(), parameters.money(),
                getProfit(parameters.rateCalculateMan(), result));
    }
}
