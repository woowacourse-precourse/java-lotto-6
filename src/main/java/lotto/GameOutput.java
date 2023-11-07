package lotto;
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
}
