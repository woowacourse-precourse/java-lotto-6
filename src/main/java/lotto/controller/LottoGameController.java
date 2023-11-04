package lotto.controller;

import lotto.Lotto;
import lotto.domain.BonusNumber;
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
                int input = convertInputToNumber(InputView.getUserInput());
                int ticketNumber = lottoOwner.purchaseLotto(input);
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
                OutputView.printLottoNumbersInputText();
                List<Integer> lottoNumbers = Arrays.stream(InputView.getUserInput().split(","))
                        .map(this::convertInputToNumber)
                        .toList();

                Lotto lottoNumber = new Lotto(lottoNumbers);
                OutputView.printBonusNumberInputText();
                BonusNumber bonusNumber = new BonusNumber(convertInputToNumber(InputView.getUserInput()));
                return new WinningNumber(lottoNumber, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int convertInputToNumber(String input) {
        validateInputNumber(input);
        return Integer.parseInt(input);
    }
    private void validateInputNumber(String input) {
        if (input.matches("\\d*")) return;
        throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
}
