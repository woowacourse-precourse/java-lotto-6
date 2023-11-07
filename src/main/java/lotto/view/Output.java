package lotto.view;

import lotto.Domain.Lotto;
import lotto.Domain.Message;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Output {

    public void printHowManyLotto(){
        System.out.println(Message.HOWMANY_LOTTO.getContent());
    }
    public void howManyLotto(){
        System.out.println(Message.BUY_MESSAGE.getContent());
    }
    public static void printLine() {
        System.out.println();
    }

    public void printLottoList(List<Lotto> lottolist) {
        for (Lotto lotto : lottolist) {
            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinNumber(){
        System.out.println(Message.INPUT_WINNER.getContent());
    }

    public void printBonusNumber(){
        System.out.println(Message.INPUT_BONUS.getContent());
    }
}
