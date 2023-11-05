package lotto.controller;


import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoGame {
    public static void run() {
        Money amount = getLottoAmount();
        Integer numberOfLotto = Calculator.getNumberOfLotto(amount.getMoney());

        Lottos lottos = LottoGenerator.makeNewLottos(numberOfLotto);
        ConsoleOutput.printLottoTickets(lottos);

        Lotto winningLotto = getLotto();
        System.out.println(winningLotto.getNumbers().toString());
    }

    private static Money getLottoAmount() {
        ConsoleOutput.askLottoAmount();
        Integer amount = ConsoleInput.readLottoAmount();
        return new Money(amount);
    }

    private static Lotto getLotto() {
        ConsoleOutput.askWinningLottoNumbers();
        return ConsoleInput.readLottoNumbers();
    }
}
