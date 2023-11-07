package lotto.controller;


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

    private static final Integer LOTTO_PRICE = 1000;
    private static final Integer MAXIMUM_LOTTO_NUMBER = 45;
    private static final Integer MINIMUM_LOTTO_NUMBER = 1;


    public static void run() {

        Money purchaseAmount = getLottoAmountFromUser();

        LottoTicket lottoTicket = generateLottoTickets(purchaseAmount);
        ConsoleOutput.printLottoTickets(lottoTicket);


        Lotto winningLotto = getLottoNumbersFromUser();
        Integer bonusNumber = getLottoBonusNumberFromUser();

        Prize result = calculateLottoPrizes(lottoTicket, winningLotto, bonusNumber);
        ConsoleOutput.printLottoPrizeResult(result);


        Double earningRate = ((double) result.getTotalPrizeAmount() / purchaseAmount.getMoney());
        ConsoleOutput.printLottoPrizeRateResult(earningRate);
    }


    private static LottoTicket generateLottoTickets(Money purchaseAmount) {

        Integer numberOfLotto = purchaseAmount.getMoney() / LOTTO_PRICE;
        LottoTicket lottoTicket = LottoFactory.makeNewLottoTicket(numberOfLotto);

        return lottoTicket;
    }

    private static Prize calculateLottoPrizes(LottoTicket lottoTicket, Lotto winningLotto, Integer bonusNumber) {

        Evaluator evaluator = new Evaluator(winningLotto, bonusNumber);
        evaluator.judgeLottoTicket(lottoTicket);

        return evaluator.getResult();
    }

    private static Money getLottoAmountFromUser() {
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

    private static Lotto getLottoNumbersFromUser() {
        while (true) {
            try {
                ConsoleOutput.askWinningLottoNumbers();
                return ConsoleInput.readLottoNumbers();

            } catch (IllegalArgumentException e) {
                ConsoleOutput.printError(e);
            }
        }
    }

    private static Integer getLottoBonusNumberFromUser() {
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
