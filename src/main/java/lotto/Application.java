package lotto;

import InputManager.InputManager;
import OutputManager.OutputManager;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Integer totalCost = InputManager.inputCost();
        List<Integer> winningNumberList = InputManager.inputWinningNumbers();
        Integer bonusNumber = InputManager.inputBonusNumber(winningNumberList);

        List<Lotto> lottoList = LottoFactory.buyLotto(totalCost);
        OutputManager.printLottoData(lottoList);

        LottoStatistics result = new LottoStatistics();
        result.calcStatistics(lottoList, winningNumberList, bonusNumber);
        OutputManager.printTotalResult(result);
    }
}
