package lotto.controller;

import lotto.constants.GameNumberConstants;
import lotto.constants.Rank;
import lotto.domain.*;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.WinningStatisticsDTO;
import lotto.utility.LottoMachine;
import lotto.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;
import static camp.nextstep.edu.missionutils.Console.close;
import static lotto.utility.GameUtility.*;
import static lotto.validator.Validator.validateBonusNumberForm;
import static lotto.validator.Validator.validateWinningNumberForm;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";

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
        RateOfReturn rateOfReturn = new RateOfReturn(calculateRateOfReturn(customer.getEarnedMoney(), customer.getPayment()));
        OutputView.printWinningStatistics(makeWinningStatisticsDTO(customer.getWinningResult(), rateOfReturn.getRateOfReturn()));
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
            validateWinningNumberForm(winningNumberString);
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
            validateBonusNumberForm(numberString);
            bonusNumber = new BonusNumber(Integer.parseInt(numberString));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            bonusNumber = getBonusNumberAndValidate();
        }
        return bonusNumber;
    }

    public static WinningStatisticsDTO makeWinningStatisticsDTO(WinningResult winningResult, float rateOfReturn) {
        String[][] winningStatisticsStrings = new String[GameNumberConstants.NUMBER_OF_WINNING_PRIZE.getValue() + 1][4];

        for (int index = 1; index <= GameNumberConstants.NUMBER_OF_WINNING_PRIZE.getValue(); index++) {
            winningStatisticsStrings[index] = new String[]{
                    Integer.toString(Rank.getNumberOfMatchesRequiredFromIndex(index)),
                    checkBonusBallString(Rank.getHasBonusNumberFromIndex(index)),
                    addCommaToNumbers(Rank.getPrizeFromIndex(index)),
                    Integer.toString(winningResult.getNumberOfPrizeFromIndex(index))};
        }
        return new WinningStatisticsDTO(winningStatisticsStrings, rateOfReturn);
    }

    public static String checkBonusBallString(int hasBonusNumber) {
        if (hasBonusNumber == 1) {
            return BONUS_BALL_MATCH;
        }
        return "";
    }

    public static String addCommaToNumbers(int amount) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(amount);
    }

    private static void endGame() {
        close();
    }
}

