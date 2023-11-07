package lotto;

import java.util.List;

public class LottoSimulator {
    static int LOTTO_PRICE = 1000;
    LottoSimulationResult simulationResult;

    LottoSimulator() {
        simulationResult = new LottoSimulationResult();
    }

    public void run() throws IllegalArgumentException {
        int count = Controller.inputPurchaseCount();
        List<Lotto> generatedLotto = Lotto.generateRandomLottos(count);
        Controller.printGeneratedLotto(generatedLotto);
        List<Integer> winningNumbers = Controller.inputWinningNumbers();
        int bonusNumber = Controller.inputBonusNumber();

        for (Lotto lotto : generatedLotto) {
            LottoMatchResult result = lotto.matchWinningNumbers(winningNumbers, bonusNumber);
            simulationResult.add(result);
        }

        Controller.printSimulationResult(simulationResult);
    }
}
