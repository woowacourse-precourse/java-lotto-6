package output;

import constant.ServiceMessage;
import java.util.List;
import lotto.Lotto;

public class LottoCounter {
    public static int countLotto(final int money) {
        int n = money / 1000;
        System.out.println();
        System.out.print(String.valueOf(n).concat(ServiceMessage.getMessageByCode(102)));
        return n;
    }

    public static void printLottos(final int money) {
        List<List<Integer>> lottos = Lotto.getLottos(money);
        for(List<Integer> lotto : lottos) {
            System.out.println(lotto.toString());
        }
    }
}
