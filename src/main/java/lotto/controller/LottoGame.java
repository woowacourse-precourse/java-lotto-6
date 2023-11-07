package lotto.controller;


import lotto.domain.Calculator;
import lotto.domain.Evaluator;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.BonusNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoGame {
    public static void run() {
        Money amount = getLottoAmount();
        Integer numberOfLotto = Calculator.getNumberOfLotto(amount.getMoney());

        LottoTicket lottoTicket = LottoFactory.makeNewLottos(numberOfLotto);
        ConsoleOutput.printLottoTickets(lottoTicket);

        Lotto winningLotto = getLotto();
        BonusNumber bonusNumber = getLottoBonusNumber();

        Evaluator evaluator = new Evaluator(winningLotto, bonusNumber);
        evaluator.judgeLottoTicket(lottoTicket);
        Prize result = evaluator.getResult();

        ConsoleOutput.printLottoPrizeResult(result);
        Double earningRate = Calculator.getEarningRate(amount.getMoney(), result.getTotalPrizeAmount());

        ConsoleOutput.printLottoPrizeRateResult(earningRate);
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

    private static BonusNumber getLottoBonusNumber() {
        ConsoleOutput.askLottoBonusNumber();
        Integer bonusNumber = ConsoleInput.readLottoBonusNumber();
        return new BonusNumber(bonusNumber);
    }
}
