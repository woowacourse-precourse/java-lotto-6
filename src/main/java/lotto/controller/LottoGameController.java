package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGameController {
    public void play() {
        LottoOwner lottoOwner = new LottoOwner();
        purchaseLottoByOwner(lottoOwner);
        WinningNumber winningNumber = generateWinningNumber();
        calculateLottoResult(lottoOwner, winningNumber);
        calculateYieldRate(lottoOwner);
    }

    private void purchaseLottoByOwner(LottoOwner lottoOwner) {
        while (true) {
            try {
                OutputView.printPurchasePriceInputText();
                int bonusNumberInput = InputView.getPaidMoneyInput();
                LottoTicket lottoTicket = lottoOwner.purchaseLotto(bonusNumberInput);
                OutputView.printTicketNumber(lottoTicket);
                OutputView.printLottoNumbers(lottoOwner.getLottos());
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumber generateWinningNumber() {
        Lotto lottoNumber = generateLottoNumber();
        while (true) {
            try {
                BonusNumber bonusNumber = generateBonusNumber();
                return new WinningNumber(lottoNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto generateLottoNumber() {
        while (true) {
            try {
                OutputView.printLottoNumbersInputText();
                List<Integer> lottoNumbers = InputView.getLottoNumbersInput();
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private BonusNumber generateBonusNumber() {
        while (true) {
            try {
                OutputView.printBonusNumberInputText();
                return new BonusNumber(InputView.getBonusNumberInput());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void calculateLottoResult(LottoOwner lottoOwner, WinningNumber winningNumber) {
        lottoOwner.calculateResult(winningNumber);
        printLottoResult();
    }

    private void printLottoResult() {
        OutputView.printLottoResultStartText();
        List<Rank> ranks = new ArrayList<>(Arrays.asList(Rank.values()));
        Collections.reverse(ranks);
        for (Rank rank : ranks) {
            OutputView.printLottoResult(rank);
        }
    }

    private void calculateYieldRate(LottoOwner lottoOwner) {
        YieldRate yieldRate = lottoOwner.calculateYieldRate();
        OutputView.printYieldRate(yieldRate);
    }
}
