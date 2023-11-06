package lotto;

import lotto.ui.InputManager;
import lotto.ui.OutputManager;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();

        LottoGenerator lottoGenerator = LottoGenerator.from(inputManager.requestAmount());
        List<Lotto> lottos = lottoGenerator.generate();
        outputManager.printLottos(lottos);

        List<Integer> numbers = inputManager.requestNumbers();
        WinningLotto winningLotto = new WinningLotto(numbers, inputManager.requestBonus(numbers));
        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningLotto);
        List<Result> results = lottoResultChecker.getResults(lottos);
        outputManager.printResults(results);
    }
}
