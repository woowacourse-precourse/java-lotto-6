package lotto;
import lotto.Messages;

public class GameOutput {
    private void printMessages(String messages){
        System.out.println(messages);
    }

    public void printUserCashInterface() {
        printMessages(Messages.ASK_LOTTO_MONNEY.getMessages());
    }

    public void printUserHopeLottoNumbersInterface() {
        printMessages(Messages.ASK_WINNING_PRIZE_NUMBERS.getMessages());
    }

    public void getUserHopeBonusNumbersInterface() {
        printMessages(Messages.ASK_BONUS_NUMBER.getMessages());
    }
}
