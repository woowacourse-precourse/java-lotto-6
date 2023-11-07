package lotto.view;

import lotto.element.Lotto;
import java.util.*;

public class Output {
    void printLottoes(List<Lotto> lottoes) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoes.size());
        for (Lotto lotto : lottoes) {
            System.out.println(lotto);
        }
    }
}
