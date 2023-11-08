package lotto.view;


import java.util.Iterator;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class ConsoleOutput {

    public static void printPurchaseAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void printAllRandomsLottos(Lottos lottos) {
        Iterator iterator = lottos.createIterator();
        while(iterator.hasNext()) {
            Lotto lotto = (Lotto)iterator.next();
            System.out.println(lotto.getNumbers());
        }
    }
}
