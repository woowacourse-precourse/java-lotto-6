package GameIO;

import java.util.List;

import static PrintEnums.Messages.*;

public class GameOutput {
    private static void printMessages(String messages) {
        System.out.println(messages);
    }

    private static void printMessages(String messages, Integer obj) {
        System.out.printf(messages, obj);
    }

    public static void printUserCashInterface() {
        printMessages(ASK_LOTTO_MONNEY.getMessage());
    }

    public static void printUserHopeLottoNumbersInterface() {
        printMessages(ASK_WINNING_PRIZE_NUMBERS.getMessage());
    }

    public static void printUserHopeBonusNumbersInterface() {
        printMessages(ASK_BONUS_NUMBER.getMessage());
    }

    public static void printEarnMoneyRatio(float earnRatio) {
        printMessages(String.format(CHECK_EARN_RATIO.getMessage() + "%.1f%%입니다.", earnRatio));
    }

    public static void printBuyTickets(int tickets) {
        printMessages(tickets + SAY_HOWMANY_BOUGHT.getMessage());
    }

    public static void printPlacedTickets(List<Integer> placed) {
        printMessages(CHECK_MATCH_THREE.getMessage() + "%d개\n", placed.get(4));
        printMessages(CHECK_MATCH_FOUR.getMessage() + "%d개\n", placed.get(3));
        printMessages(CHECK_MATCH_FIVE.getMessage() + "%d개\n", placed.get(2));
        printMessages(CHECK_MATCH_BONUS.getMessage() + "%d개\n", placed.get(1));
        printMessages(CHECK_MATCH_SIX.getMessage() + "%d개\n", placed.get(0));
    }

}
