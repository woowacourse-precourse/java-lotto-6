package lotto.controller;

import lotto.collection.Lotto;
import lotto.domain.ResultNumber;
import lotto.domain.User;
import lotto.dto.LottoTicketsDTO;
import lotto.utility.GameUtility;
import lotto.validator.LottoNumberValidator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private LottoGame() {}

    public static void run() {
        int payment = getPaymentAndValidate();
        User user = GameUtility.buyTickets(payment);

        OutputView.printLottoTickets(new LottoTicketsDTO(
                        user.getLottoTickets().size(),
                        user.getLottoTickets())
        );

        OutputView.printLineBreak();

        List<Integer> winningNumber = getWinningNumberAndValidate();
        int bonusNumber = getBonusNumberAndValidate(winningNumber);
        ResultNumber resultNumber = ResultNumber.create(winningNumber, bonusNumber);
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

    private static List<Integer> getWinningNumberAndValidate() {
        String winningNumberString;
        List<Integer> winningNumber;
        try {
            OutputView.printInputWinningNumber();
            winningNumberString = InputView.receiveUserInput();
            Validator.checkWinningNumberForm(winningNumberString);
            winningNumber = Arrays.stream(winningNumberString.split(","))
                                                        .map((number) -> Integer.parseInt(number))
                                                        .toList();
            LottoNumberValidator.validateLottoNumber(winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            winningNumber = getWinningNumberAndValidate();
        }
        return winningNumber;
    }


    private static int getBonusNumberAndValidate(List<Integer> winningNumber) {
        String bonusNumberString;
        int bonusNumber;
        try {
            OutputView.printInputBonusNumber();
            bonusNumberString = InputView.receiveUserInput();
            LottoNumberValidator.validateBonusNumber(bonusNumberString);
            bonusNumber = Integer.parseInt(bonusNumberString);
            LottoNumberValidator.validateDuplication(bonusNumber,winningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = getBonusNumberAndValidate(winningNumber);
        }
        return bonusNumber;
    }

}

