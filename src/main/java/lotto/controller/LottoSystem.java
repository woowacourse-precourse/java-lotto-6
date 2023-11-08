package lotto.controller;

import static lotto.error.ExceptionCode.EXCEED_MAX_TRY;
import static lotto.view.ErrorOutput.printError;
import static lotto.view.Input.readBuyAmount;

import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.WinnerNumbers;
import lotto.error.LottoException;
import lotto.infra.RandomNumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class LottoSystem {

    private final static int MAX_TRY = 5;

    private final LottoSeller lottoSeller;

    public LottoSystem() {
        this.lottoSeller = new LottoSeller(new RandomNumberGenerator());
    }

    public void run() {
        try {
            final Money moneyForBuy = readMoneyForBuy();
            final Lottos lottos = buyLottos(moneyForBuy);
            Output.printBoughtLotto(lottos);
            final WinnerNumbers winnerNumbers = readWinnerNumbers();
            final Result result = lottos.getResult(winnerNumbers);
            Output.printResult(result, moneyForBuy);
        } catch (RuntimeException e) {
            printError(e);
        }
    }

    private Money readMoneyForBuy() {
        for (int tryCount = 1; tryCount <= MAX_TRY; ++tryCount) {
            try {
                return new Money(readBuyAmount());
            } catch (final RuntimeException e) {
                printError(e);
            }
        }
        throw new LottoException(EXCEED_MAX_TRY);
    }

    private Lottos buyLottos(final Money money) {
        for (int tryCount = 1; tryCount <= MAX_TRY; ++tryCount) {
            try {
                return lottoSeller.buy(money);
            } catch (final RuntimeException e) {
                printError(e);
            }
        }
        throw new LottoException(EXCEED_MAX_TRY);
    }

    private WinnerNumbers readWinnerNumbers() {
        for (int tryCount = 1; tryCount <= MAX_TRY; ++tryCount) {
            try {
                return new WinnerNumbers(Input.readWinnerNumbers(), Input.readBonusNumber());
            } catch (final RuntimeException e) {
                printError(e);
            }
        }
        throw new LottoException(EXCEED_MAX_TRY);
    }
}
