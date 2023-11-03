package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class OutputUI {

    public void rate(long winningRate) {
        System.out.println("총 수익률은 " + winningRate + "%입니다.");
    }

    public void purchaseLog(int num, String lotto) {
        System.out.println(num + "개를 구매했습니다.");
        for (int i = 0; i < num; i++) {
            System.out.println(lotto);
        }

    }

}
