package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Winning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;
import static lotto.view.InputValidator.*;

public class InputView {

    public static Buyer payForLottery() {
        try {
            int paymentNumber = getPaymentNumber();
            int ticketCount = calculateTicketCount(paymentNumber);
            Buyer buyer = new Buyer(paymentNumber, ticketCount);
            printTickets(buyer);
            return buyer;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Lotto inputWinningNum() {
        while (true) {
            String input = getWinningNumbersFromUser();
            try {
                Lotto lotto = createLottoFromInput(input);
                return lotto;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getWinningNumbersFromUser() {
        System.out.println(INPUT_WINNING_LOTTO);
        return Console.readLine();
    }

    private static Lotto createLottoFromInput(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(",",-1))
                .map(String::trim)
                .map(InputValidator::parsePayment)
                .collect(Collectors.toList());

        return new Lotto(winningNumbers);
    }

    public static Winning inputBonusNum(Lotto lotto) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = getBonusNumberFromUser();
                checkDuplicateBonusNumber(bonusNumber, lotto);
                return new Winning(lotto, bonusNumber);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumberFromUser() {
        System.out.println(INPUT_BONUS_NUMBER);
        String input = Console.readLine();
        return parsePayment(input);
    }

    public static int getPaymentNumber() {
        System.out.println(BUY_LOTTERY_INPUT);
        String payment = Console.readLine();
        return parsePayment(payment);
    }

    public static void printTickets(Buyer buyer) {
        printTicketCnt(buyer);
        printLotto(buyer);
    }

    public static void printTicketCnt(Buyer buyer) {
        System.out.printf(TICKETS_COUNT_OUTPUT, buyer.getTicketCnt());
    }

    public static void printTicketCntForTest(int payment) {
        System.out.printf(TICKETS_COUNT_OUTPUT, payment / 1000);
    }

    public static void printLotto(Buyer buyer) {
        for (Lotto numbers : buyer.getLotto()) {
            System.out.println(numbers.getNumbers());
        }
    }
}
