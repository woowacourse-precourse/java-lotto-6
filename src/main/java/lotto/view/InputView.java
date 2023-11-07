package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.utils.Constants.BUY_LOTTERY_INPUT;
import static lotto.utils.Constants.TICKETS_COUNT_OUTPUT;

public class InputView {

    public static void payForLottery() {
        System.out.println(BUY_LOTTERY_INPUT);
        try {
            String payment = Console.readLine();
            int paymentNumber = checkPaymentIsNumber(payment);
            int cnt = checkTruncatedTo1000(paymentNumber);
            printTicketCnt(cnt);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printTicketCnt(int cnt) {
        System.out.println();
        System.out.printf(TICKETS_COUNT_OUTPUT, cnt);
    }

    public static int checkTruncatedTo1000(int payment) {
        if(payment % 1000 != 0) throw new IllegalArgumentException("[ERROR] 1,000원 단위 이상으로만 입력하세요.");
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
