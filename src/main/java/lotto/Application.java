package lotto;

import lotto.ui.InputManager;
import lotto.ui.OutputManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();

        int amount = inputManager.requestAmount();
        List<Lotto> lottos = LottoGenerator.generateFrom(amount);
        outputManager.printLottos(lottos);

        List<Integer> numbers = inputManager.requestNumbers();
        int bonus = inputManager.requestBonus(numbers);
        WinningLotto winningLotto = WinningLotto.of(numbers, bonus);

        List<Result> results = LottoResultChecker.getResultsOf(winningLotto, lottos);
        outputManager.printResults(results);
    }
}