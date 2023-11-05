package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public static void printPurchaseHistory(List<Lotto> list) {
        print(String.format("%d개를 구매했습니다.", list.size()));
        for (Lotto lotto : list) {
            List<Integer> lottoNumbers = lotto.getList();
            print(lottoNumbers.stream().sorted().toList().toString());
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
