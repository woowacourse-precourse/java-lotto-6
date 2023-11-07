package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Issue {
    public static int initialCash;
    public static List<List<Integer>> lottoGroup = new ArrayList<>();
    public static final int MINIMUM_OF_NUMBER = 1;
    public static final int MAXIMUM_OF_NUMBER = 45;
    public static final int NUMBER_OF_LOTTO = 6;

    private static int lottoQuantity;
    private static final int UNIT_OF_CASH = 1000;

    static void inputCash() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                initialCash = Integer.parseInt(Console.readLine());
                raiseUnitException();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println("[ERROR] 올바른 숫자를 입력해야 합니다.");
            }
        }

        lottoQuantity = initialCash / UNIT_OF_CASH;
        System.out.println();
    }

    private static List<Integer> getNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_OF_NUMBER, MAXIMUM_OF_NUMBER, NUMBER_OF_LOTTO);
    }

    static void makeSortedLotto() {
        for (int i = 0; i < lottoQuantity; i++) {
            Lotto transfer = new Lotto(getNumbers());

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

    private static void raiseUnitException() {
        if (initialCash % UNIT_OF_CASH != 0) {
            throw new IllegalArgumentException();
        }
    }
}
