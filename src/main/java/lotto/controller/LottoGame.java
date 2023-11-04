package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.dto.LottoTicketsDTO;
import lotto.utility.GameUtility;
import lotto.validator.LottoNumberValidator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.validator.LottoNumberValidator.validateNumberRange;

public class LottoGame {

    private LottoGame() {}

    public static void run() {
        int payment = getPaymentAndValidate();
        User user = GameUtility.buyTickets(payment);

        OutputView.printLottoTickets(
                new LottoTicketsDTO(
                        user.getLottoTickets().size(),
                        user.getLottoTickets())
        );

        OutputView.printLineBreak();
        WinningNumber winningNumber = new WinningNumber(getWinningNumberAndValidate(),getBonusNumberAndValidate());
    }

    private static int getPaymentAndValidate() {
        String paymentString;
        int payment;
        try {
            OutputView.printInputPurchaseAmount();
            paymentString = InputView.receiveUserInput();

            Validator.isPrimeNumber(paymentString);
            Validator.isPositiveNumber(paymentString);
            Validator.isUnitsOfLottoPrice(paymentString);
            payment = Integer.parseInt(paymentString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            payment = getPaymentAndValidate();
        }

        return payment;
    }

    private static Lotto getWinningNumberAndValidate() {
        String lottoString;
        Lotto lotto;
        try {
            OutputView.printInputWinningNumber();
            lottoString = InputView.receiveUserInput();
            Validator.checkWinningNumberForm(lottoString);

            lotto = new Lotto(Arrays.stream(lottoString.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            lotto = getWinningNumberAndValidate();
        }

        return lotto;
    }

    private static int getBonusNumberAndValidate() {
        String bonusNumberString;
        int bonusNumber;
        try {
            OutputView.printInputBonusNumber();
            bonusNumberString = InputView.receiveUserInput();
            Validator.isPrimeNumber(bonusNumberString);

            bonusNumber = Integer.parseInt(bonusNumberString);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = getBonusNumberAndValidate();
        }

        return bonusNumber;
    }

}

