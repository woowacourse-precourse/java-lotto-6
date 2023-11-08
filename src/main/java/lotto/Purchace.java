package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Purchace {
    private static int times;
    protected static List<List<Integer>> lottoes;

    public Purchace(int times) {
        this.times = times;
        this.lottoes = allPurchase();
    }

    private static List<List<Integer>> allPurchase() {
        List<List<Integer>> purchaseLottoes = new ArrayList<>();

        for (int i = 0; i < times; i++) {
            purchaseLottoes.add(eachPurchase());
        }
        printLottoNumbers(purchaseLottoes);
        return purchaseLottoes;
    }

    private static List<Integer> eachPurchase() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    private static void printLottoNumbers(List<List<Integer>> purchaseLottoes) {
        System.out.println(times + "개를 구입했습니다.");
        for (int i = 0; i < times; i++) {
            System.out.println(purchaseLottoes.get(i));
        }
        System.out.println();
    }
}
