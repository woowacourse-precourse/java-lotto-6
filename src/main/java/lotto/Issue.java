package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Issue {
    private static int lottoQuantity;
    public static int initialCash;
    public static List<List<Integer>> lottoGroup = new ArrayList<>();

    static void inputCash() {
        initialCash = Integer.parseInt(Console.readLine());
        lottoQuantity = initialCash / 1000;
    }

    private static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    static void makeSortedLotto() {
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto transfer = new Lotto(getNumbers());

            transfer.sort();
            List<Integer> convertedLotto = transfer.convertType();
            lottoGroup.add(convertedLotto);
        }
    }

    static void printLotto() {
        for (int i = 0; i < lottoGroup.size(); i++) {
            System.out.println(lottoGroup.get(i));
        }
    }

    public static void playIssue() {
        inputCash();
        makeSortedLotto();
        printLotto();
    }
}
