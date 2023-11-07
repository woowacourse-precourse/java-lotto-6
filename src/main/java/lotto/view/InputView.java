package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.utils.Constants.BUY_LOTTERY_INPUT;
import static lotto.utils.Constants.TICKETS_COUNT_OUTPUT;

public class InputView {

    public static void payForLottery() {
        System.out.println(BUY_LOTTERY_INPUT);
        try {
            String payment = Console.readLine();
            int paymentNumber = checkPaymentIsNumber(payment);
            int cnt = checkTruncatedTo1000(paymentNumber);
            Buyer buyer = new Buyer(paymentNumber, cnt);
            printTickets(buyer);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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

    public static int checkTruncatedTo1000(int payment) {
        if (payment % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1,000원 단위 이상으로만 입력하세요.");
        return payment / 1000;
    }

    private static int checkPaymentIsNumber(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }
}
