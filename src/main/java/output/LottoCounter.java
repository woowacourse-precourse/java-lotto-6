package output;

import constant.ServiceMessage;
import java.util.List;
import lotto.Lotto;

public class LottoCounter {
    public static int countLotto(final int money) {
        int n = money / 1000;
        System.out.println();
        System.out.println(String.valueOf(n).concat(ServiceMessage.getMessageByCode(102)));
        return n;
    }
}
