package controller;

import lotto.Lotto;
import model.ProfitCalculable;
import model.LottoJudge;
import view.Mainview;

class ResultHelperController {
    private Mainview mainview;

    public ResultHelperController(Mainview mainview) {
        this.mainview = mainview;
    }

    private int[] processResult(LottoJudge judgeMan, Lotto userLotto, int bonusNumber) {
        int[] result = judgeMan.judgeLotto(userLotto, bonusNumber);
        mainview.printHowManyAndLottos(judgeMan.getComputerLottos());
        mainview.printresult(result);
        return result;
    }

    private int getProfit(ProfitCalculable profitCalculateMan, int[] result) {
        return profitCalculateMan.calculateProfit(result);
    }

    // 내 생각은 이 메소드에서 차례차례 호출하도록 하는 거임
    // 먼저 게임의 결과를 호출하면서 바로 그걸로 수익을 얻고
    //그리고 이거 그대로 가면 됨

    private void processRateofProfit(ProfitCalculable rateCalculateMan, int money, int profit) {
        String rateOfProfit = rateCalculateMan.calculateRateOfProfit(String.valueOf(money), profit);
        mainview.printRateOfProfit(rateOfProfit);
    }

    void processLottoGame(ProcessLottoGameParameters parameters) {
        int[] result = processResult(parameters.judgeMan(),
                parameters.userLotto(), parameters.bonusNumber());
        processRateofProfit(parameters.rateCalculateMan(), parameters.money(),
                getProfit(parameters.rateCalculateMan(), result));

    }
}
