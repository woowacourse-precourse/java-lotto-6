package lotto.service;

import static lotto.utils.Converter.convertToInt;
import static lotto.utils.Converter.splitBySeparator;
import static lotto.view.OutputView.printEnterBonusNumber;
import static lotto.view.OutputView.printEnterWinningNumbers;
import static lotto.view.OutputView.printErrorMessage;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.exception.LottoGameException;
import lotto.view.InputView;

public class WinningLottoService {

    public WinningLotto receiveWinningLotto() {
        try {
            final Lotto winningNumbers = receiveWinningNumbers();
            return receiveWinningLottoWithBonusNumber(winningNumbers);
        } catch (LottoGameException exception) {
            printErrorMessage(exception);
            return receiveWinningLotto();
        }
    }

    private WinningLotto receiveWinningLottoWithBonusNumber(final Lotto winningNumbers) {
        printEnterBonusNumber();
        return repeatUntilReceiveWinningLotto(winningNumbers);
    }

    private WinningLotto repeatUntilReceiveWinningLotto(final Lotto winningNumbers) {
        try {
            final Integer bonusNumber = repeatUntilReceiveBonusNumber();
            return WinningLotto.of(winningNumbers, bonusNumber);
        } catch (LottoGameException exception) {
            printErrorMessage(exception);
            return repeatUntilReceiveWinningLotto(winningNumbers);
        }
    }

    private int repeatUntilReceiveBonusNumber() {
        try {
            final String input = InputView.readLine();
            return convertToInt(input);
        } catch (LottoGameException exception) {
            printErrorMessage(exception);
            return repeatUntilReceiveBonusNumber();
        }
    }

    private Lotto receiveWinningNumbers() {
        printEnterWinningNumbers();
        return repeatUntilReceiveWinningNumbers();
    }

    private Lotto repeatUntilReceiveWinningNumbers() {
        try {
            final String input = InputView.readLine();
            final List<Integer> winningNumbers = splitBySeparator(input);
            return new Lotto(winningNumbers);
        } catch (LottoGameException exception) {
            printErrorMessage(exception);
            return repeatUntilReceiveWinningNumbers();
        }
    }
}
