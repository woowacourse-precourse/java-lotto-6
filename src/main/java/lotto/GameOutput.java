package lotto;
import java.util.ArrayList;
import java.util.List;
import lotto.Messages;

public class GameOutput {
    private static void printMessages(String messages){
        System.out.println(messages);
    }

    public static void printUserCashInterface() {
        printMessages(Messages.ASK_LOTTO_MONNEY.getMessages());
    }

    public static void printUserHopeLottoNumbersInterface() {
        printMessages(Messages.ASK_WINNING_PRIZE_NUMBERS.getMessages());
    }

    public static void getUserHopeBonusNumbersInterface() {
        printMessages(Messages.ASK_BONUS_NUMBER.getMessages());
    }

    public static List<String> printBuyTickets(Lotto lotto, int tickets){
        printMessages(tickets+Messages.SAY_HOWMANY_BOUGHT.getMessages());
        List<String> ticketString = new ArrayList<>();
        for ( int i = 0 ; i < tickets ; i++ ) {
            String str = lotto.pickRandoms().toString();
            ticketString.add(str);
            System.out.println(str);
        }
        return ticketString;
    }

}
