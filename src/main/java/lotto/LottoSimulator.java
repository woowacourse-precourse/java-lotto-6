package lotto;

import java.util.List;

public class LottoSimulator {
    static int LOTTO_PRICE = 1000;
    LottoSimulationResult simulationResult;

    public void run() {
        int count = getPurchaseCount();
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

    private int getPurchaseCount() {
        int amount = Controller.inputPurchaseAmount();
        // TODO: 미구현
        return 0;
    }
}
