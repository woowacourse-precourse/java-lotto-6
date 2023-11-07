package lotto.view;

import java.util.List;

public class IssueLottoView {
    public void printLottos(List<Integer> lottos) {
        System.out.println(lottos.toString());
    }

    public void printAmmount(int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
    }
}
