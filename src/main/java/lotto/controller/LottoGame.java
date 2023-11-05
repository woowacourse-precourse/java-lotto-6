package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoTicketsDTO;
import lotto.utility.GameUtility;
import lotto.validator.LottoNumberValidator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private LottoGame() {}

    public static void run() {
        Payment payment = getPaymentAndValidate();
        User user = GameUtility.buyTickets(payment.getPayment());
        OutputView.printLottoTickets(new LottoTicketsDTO(
                        user.getLottoTickets().size(),
                        user.getLottoTickets())
        );
        OutputView.printLineBreak();
        WinningNumber winningNumber = getWinningNumberAndValidate();
        BonusNumber bonusNumber = getBonusNumberAndValidate();
        ResultNumber.create(winningNumber, bonusNumber);
        GameUtility.checkLottoWinning(user);
    }

    private static Payment getPaymentAndValidate() {
        String paymentString;
        Payment payment;
        try {
            OutputView.printInputPurchaseAmount();
            paymentString = InputView.receiveUserInput();
            Validator.isPrimeNumber(paymentString);
            payment = new Payment(Integer.parseInt(paymentString));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            payment = getPaymentAndValidate();
        }
        return payment;
    }

    private static WinningNumber getWinningNumberAndValidate() {
        String winningNumberString;
        WinningNumber winningNumber;
        try {
            OutputView.printInputWinningNumber();
            winningNumberString = InputView.receiveUserInput();
            Validator.checkWinningNumberForm(winningNumberString);
            Validator.areAllPrimeNumber(List.of(winningNumberString.split(",")));
            winningNumber = WinningNumber.create(stringToIntList(winningNumberString));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumber = getWinningNumberAndValidate();
        }
        return winningNumber;
    }

    private static List<Integer> stringToIntList(String input) {
        return Arrays.stream(input.split(","))
                .map((number) -> Integer.parseInt(number))
                .toList();
    }


    private static BonusNumber getBonusNumberAndValidate() {
        String numberString;
        BonusNumber bonusNumber;
        try {
            OutputView.printInputBonusNumber();
            numberString = InputView.receiveUserInput();
            LottoNumberValidator.validateBonusNumber(numberString);
            bonusNumber = BonusNumber.create(Integer.parseInt(numberString));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = getBonusNumberAndValidate();
        }
        return bonusNumber;
    }

}

