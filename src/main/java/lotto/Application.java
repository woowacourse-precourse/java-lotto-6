package lotto;

import lotto.ui.InputManager;
import lotto.ui.OutputManager;

import java.util.List;

public class Application {
    static final InputManager inputManager = new InputManager();
    static final OutputManager outputManager = new OutputManager();

    public static void main(String[] args) {
        List<Lotto> lottos = createLottos();
        outputManager.printLottos(lottos);

        WinningLotto winningLotto = createWinningLotto();

        List<Result> results = LottoResultChecker.getResultsOf(winningLotto, lottos);
        outputManager.printResults(results);
    }

    public static List<Lotto> createLottos() {
        while (true) {
            try {
                int amount = inputManager.requestAmount();
                return LottoGenerator.generateFrom(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto createLotto() {
        while (true) {
            try {
                List<Integer> numbers = inputManager.requestNumbers();
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningLotto createWinningLotto() {
        Lotto winningNumbers = createLotto();

        while (true) {
            try {
                int bonus = inputManager.requestBonus(winningNumbers.getNumbers());
                return WinningLotto.of(winningNumbers, bonus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}