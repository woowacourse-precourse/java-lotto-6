package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Purchace {
    private static int times;

    public Purchace(int times) {
        this.times = times;
        allPurchase();
    }

    private static void allPurchase() {
        List<Lotto> purchaseLottoes = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            purchaseLottoes.add(eachPurchase());
        }
        printLottoNumbers(purchaseLottoes);
    }

    private static Lotto eachPurchase() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Lotto lotto = new Lotto(numbers);

        return lotto;
    }

    private static void printLottoNumbers(List<Lotto> purchaseLottoes) {
        System.out.println(times + "개를 구입했습니다.");
        for (int i = 0; i < times; i++) {
            purchaseLottoes.get(i).printLotto();
        }
        System.out.println();
    }
}
