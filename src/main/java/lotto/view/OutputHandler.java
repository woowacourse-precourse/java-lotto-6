package lotto.view;

import java.util.List;
import lotto.constant.SystemMessage;

public class OutputHandler {

    public static void requirePaymentPrice() {
        System.out.println(SystemMessage.REQUIRE_PAYMENT_PRICE);
    }

    public static void sayTicketCount(int ticketCount) {
        System.out.println(ticketCount + SystemMessage.SAY_TICKET_COUNT_FORMAT);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void requireWinningNumbers() {
        System.out.println(SystemMessage.REQUIRE_WINNING_NUMBERS);
    }

    public static void requireBonusNumber() {
        System.out.println(SystemMessage.REQUIRE_BONUS_NUMBER);
    }

}