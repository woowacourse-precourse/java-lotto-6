package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

import static lotto.utils.Constants.BUY_LOTTERY_INPUT;
import static lotto.utils.Constants.TICKETS_COUNT_OUTPUT;
import static lotto.view.InputValidator.calculateTicketCount;
import static lotto.view.InputValidator.parsePayment;

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
}
