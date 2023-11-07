package lotto.controller;


import lotto.domain.Calculator;
import lotto.domain.Evaluator;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.exception.InvalidNumberScopeException;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

public class LottoGame {
    private static final Integer MAXIMUM_LOTTO_NUMBER = 45;
    private static final Integer MINIMUM_LOTTO_NUMBER = 1;

    public static void run() {
        Money amount = getLottoAmount();
        Integer numberOfLotto = Calculator.getNumberOfLotto(amount.getMoney());

        LottoTicket lottoTicket = LottoFactory.makeNewLottoTicket(numberOfLotto);
        ConsoleOutput.printLottoTickets(lottoTicket);

        Lotto winningLotto = getLotto();
        Integer bonusNumber = getLottoBonusNumber();

        Evaluator evaluator = new Evaluator(winningLotto, bonusNumber);
        evaluator.judgeLottoTicket(lottoTicket);
        Prize result = evaluator.getResult();

        ConsoleOutput.printLottoPrizeResult(result);
        Double earningRate = Calculator.getEarningRate(amount.getMoney(), result.getTotalPrizeAmount());

        ConsoleOutput.printLottoPrizeRateResult(earningRate);
    }

    private static Money getLottoAmount() {
        while (true) {
            try {
                ConsoleOutput.askLottoAmount();
                Integer amount = ConsoleInput.readLottoAmount();
                return new Money(amount);

            } catch (IllegalArgumentException e) {
                ConsoleOutput.printError(e);
            }
        }
    }

    private static Lotto getLotto() {
        while (true) {
            try {
                ConsoleOutput.askWinningLottoNumbers();
                return ConsoleInput.readLottoNumbers();

            } catch (IllegalArgumentException e) {
                ConsoleOutput.printError(e);
            }
        }
    }

    private static Integer getLottoBonusNumber() {
        while (true) {
            try {
                ConsoleOutput.askLottoBonusNumber();
                Integer bonusNumber = ConsoleInput.readLottoBonusNumber();
                checkNumberScope(bonusNumber);

                return bonusNumber;

            } catch (IllegalArgumentException e) {
                ConsoleOutput.printError(e);
            }
        }
    }

    private static void checkNumberScope(Integer number) {
        if (number < MINIMUM_LOTTO_NUMBER) {
            throw new InvalidNumberScopeException();
        }
        if (number > MAXIMUM_LOTTO_NUMBER) {
            throw new InvalidNumberScopeException();
        }
    }
}
