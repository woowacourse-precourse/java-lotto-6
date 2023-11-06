package lotto.controller;


import lotto.domain.Calculator;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoGame {
    public static void run() {
        Money amount = getLottoAmount();
        Integer numberOfLotto = Calculator.getNumberOfLotto(amount.getMoney());

        LottoTicket lottoTicket = LottoGenerator.makeNewLottos(numberOfLotto);
        ConsoleOutput.printLottoTickets(lottoTicket);

        Lotto winningLotto = getLotto();
        Integer bonusNumber = getLottoBonusNumber();

        
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

    private static Integer getLottoBonusNumber() {
        ConsoleOutput.askLottoBonusNumber();
        // TODO: Parser?
        return ConsoleInput.readLottoBonusNumber();
    }
}
