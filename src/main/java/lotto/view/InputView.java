package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

import static lotto.utils.Constants.BUY_LOTTERY_INPUT;
import static lotto.utils.Constants.TICKETS_COUNT_OUTPUT;
import static lotto.utils.ErrorMessages.INPUT_NUMBER_FORMAT;
import static lotto.utils.ErrorMessages.PAYMENT_OVER_1000_UNIT;

public class InputView {

    public static void payForLottery() {
        System.out.println(BUY_LOTTERY_INPUT);
        try {
            int paymentNumber = getPaymentNumber();
            int ticketCount = calculateTicketCount(paymentNumber);
            Buyer buyer = new Buyer(paymentNumber, ticketCount);
            printTickets(buyer);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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
        System.out.println();
        System.out.printf(TICKETS_COUNT_OUTPUT, buyer.getTicketCnt());
    }

    public static void printTicketCntForTest(int payment) {
        System.out.println();
        System.out.printf(TICKETS_COUNT_OUTPUT, payment / 1000);
    }

    public static void printLotto(Buyer buyer) {
        for (Lotto numbers :buyer.getLotto()){
            System.out.println(numbers.getNumbers());
        }
    }

    public static int calculateTicketCount(int payment) {
        if (payment % 1000 != 0) throw new IllegalArgumentException(PAYMENT_OVER_1000_UNIT);
        return payment / 1000;
    }

    private static int parsePayment(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INPUT_NUMBER_FORMAT);
        }
    }
}
