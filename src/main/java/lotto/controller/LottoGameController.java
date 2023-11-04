package lotto.controller;

import lotto.domain.LottoOwner;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
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
                int ticketNumber = lottoOwner.purchaseLotto(InputView.getUserInput());
                OutputView.printTicketNumber(ticketNumber);
                OutputView.printLottoNumbers(lottoOwner.getLottoNumbers());
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningNumber generateWinningNumber() {
        while (true) {
            try {
                OutputView.printLottoNumbersInput();
                List<String> lottoNumbers = Arrays.asList(InputView.getUserInput().split(","));
                return new WinningNumber(lottoNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

}
