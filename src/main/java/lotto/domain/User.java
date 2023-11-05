package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class User {
    private static int consumedMoney;
    private static List<Lotto> lottoList;
    private static int receivedMoney;

    public static void consumeMoney(int consumedMoney) {
        User.consumedMoney = consumedMoney;
    }

    public static void acquireLottoList(List<Lotto> lottoList) {
        User.lottoList = lottoList;
    }

    public static void receiveMoney(int receivedMoney) {
        User.receivedMoney = receivedMoney;
    }

    
}
