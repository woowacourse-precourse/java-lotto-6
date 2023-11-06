package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.WinningStatisticsDTO;
import lotto.utility.LottoMachine;
import lotto.validator.LottoNumberValidator;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import static camp.nextstep.edu.missionutils.Console.close;
import static lotto.utility.GameUtility.*;

import java.util.Arrays;
import java.util.List;

public class LottoGame {

    private LottoGame() {
    }

    public static void run() {
        Payment payment = getPaymentAndValidate();
        List<Lotto> tickets = LottoMachine.generateTickets(payment.getPayment());
        Customer customer = new Customer(payment, tickets);
        printCustomerTickets(customer);
        makeWinningAndBonusNumber();
        customer.setWinningResult(calculateCustomerWinningResult(customer));
        customer.setEarnedMoney(calculateEarnedMoney(customer));
        double rateOfReturn = calculateRateOfReturn(customer.getEarnedMoney(), customer.getPayment());
        OutputView.printWinningStatistics(new WinningStatisticsDTO(customer.getWinningResult(), rateOfReturn));
        endGame();
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

    private static void printCustomerTickets(Customer customer) {
        OutputView.printLottoTickets(new LottoTicketsDTO(
                customer.getLottoTickets().size(),
                customer.getLottoTickets())
        );
    }

    private static WinningAndBonusNumber makeWinningAndBonusNumber() {
        WinningNumber winningNumber = getWinningNumberAndValidate();
        BonusNumber bonusNumber = getBonusNumberAndValidate();
        return WinningAndBonusNumber.create(winningNumber, bonusNumber);
    }

    private static WinningNumber getWinningNumberAndValidate() {
        String winningNumberString;
        WinningNumber winningNumber;
        try {
            OutputView.printInputWinningNumber();
            winningNumberString = InputView.receiveUserInput();
            Validator.checkWinningNumberForm(winningNumberString);
            Validator.areAllPrimeNumber(List.of(winningNumberString.split(",")));
            winningNumber = new WinningNumber(stringToIntList(winningNumberString));

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
            bonusNumber = new BonusNumber(Integer.parseInt(numberString));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = getBonusNumberAndValidate();
        }
        return bonusNumber;
    }

    private static void endGame() {
        close();
    }
}

