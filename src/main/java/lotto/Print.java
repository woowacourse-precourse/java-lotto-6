package lotto;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public void printPurchasedLottos(List<Lotto> lottos) {
        printNumbersOfLotto(lottos.size());
        for (Lotto lotto: lottos) {
            System.out.println(sort(lotto).toString());
        }
        System.out.println();
    }

    private void printNumbersOfLotto(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    List<Integer> sort(Lotto lotto) {
        List<Integer> numbers = new ArrayList<>(lotto.getNumbers());
        numbers.sort(null);
        return numbers;
    }
}
