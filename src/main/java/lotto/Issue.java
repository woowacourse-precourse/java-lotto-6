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
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                initialCash = Integer.parseInt(Console.readLine());
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해야 합니다.");
            }
        }

        lottoQuantity = initialCash / 1000;
        System.out.println();
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
        System.out.println(lottoQuantity + "개를 구매했습니다.");

        for (int i = 0; i < lottoGroup.size(); i++) {
            System.out.println(lottoGroup.get(i));
        }

        System.out.println();
    }

    public static void playIssue() {
        inputCash();
        makeSortedLotto();
        printLotto();
    }
}
