package lotto.controller;

import lotto.Lotto;
import lotto.domain.BonusNumber;
import lotto.domain.LottoOwner;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {
    public void play() {
        LottoOwner lottoOwner = new LottoOwner();
        purchaseLottoByOwner(lottoOwner);
        WinningNumber winningNumber = generateWinningNumber();
    }

    private void purchaseLottoByOwner(LottoOwner lottoOwner) {
        while (true) {
            try {
                OutputView.printPurchasePriceInputText();
                int bonusNumberInput = InputView.getPaidMoneyInput();
                int ticketNumber = lottoOwner.purchaseLotto(bonusNumberInput);
                OutputView.printTicketNumber(ticketNumber);
                OutputView.printLottoNumbers(lottoOwner.getLottoNumbers());
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

}
