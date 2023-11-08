package output;

import constant.ServiceMessage;

public class LottoCounter {
    public static int countLotto(final int money) {
        int n = money / 1000;
        System.out.println();
        System.out.print(String.valueOf(n).concat(ServiceMessage.getMessageByCode(102)));
        return n;
    }
}
