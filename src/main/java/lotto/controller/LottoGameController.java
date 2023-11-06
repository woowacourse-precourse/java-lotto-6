package lotto.controller;

import static lotto.utils.Converter.convertToInt;
import static lotto.utils.Converter.splitBySeparator;
import static lotto.view.OutputView.printEnterBonusNumber;
import static lotto.view.OutputView.printEnterPurchaseAmount;
import static lotto.view.OutputView.printEnterWinningNumbers;
import static lotto.view.OutputView.printErrorMessage;
import static lotto.view.OutputView.printLotteriesInfo;

import java.util.List;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.Payment;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class LottoGameController {
    
    public void start() {
        final Payment payment = receivePayment();
        final Lotteries lotteries = purchaseLotteries(payment);
        final WinningLotto winningLotto = receiveWinningLotto();
    }
    
    private WinningLotto receiveWinningLotto() {
        try {
            printEnterWinningNumbers();
            final Lotto winningNumbers = receiveWinningNumbers();
            printEnterBonusNumber();
            final Integer bonusNumber = receiveBonusNumber();
            return WinningLotto.of(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return receiveWinningLotto();
        }
    }
    
    private int receiveBonusNumber() {
        try {
            final String input = InputView.readLine();
            return convertToInt(input);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return receiveBonusNumber();
        }
    }
    
    private Lotto receiveWinningNumbers() {
        try {
            final String input = InputView.readLine();
            List<Integer> winningNumbers = splitBySeparator(input);
            return new Lotto(winningNumbers);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return receiveWinningNumbers();
        }
    }
    
    private Lotteries purchaseLotteries(final Payment payment) {
        Lotteries lotteries = Lotteries.from(payment);
        List<String> lotteriesInfo = lotteries.receiveLotteriesInfo();
        
        printLotteriesInfo(lotteriesInfo);
        
        return lotteries;
    }
    
    private Payment receivePayment() {
        printEnterPurchaseAmount();
        
        try {
            String payment = InputView.readLine();
            return Payment.from(payment);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception);
            return receivePayment();
        }
    }
}
