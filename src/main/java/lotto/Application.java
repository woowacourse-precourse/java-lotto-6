package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Application {

    private static int isInt(String value) {
        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
            }
        }

        return Integer.parseInt(value);
    }

    private static int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money;

        try {
            money = isInt(Console.readLine());
            if (money % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액이 1,000원 단위가 아닙니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseMoney();
        }
        return getLottoAmount(money);
    }

    private static int getLottoAmount(int m) {
        System.out.println("\n" + m / 1000 + "개를 구매했습니다.");
        return m / 1000;
    }

    public static void main(String[] args) {
        int lottoAmount = inputPurchaseMoney();

        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < lottoAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            System.out.println(lotto.getNumbers());
            lottos.add(lotto);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        int[] prizeNum = Stream.of(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNum = Integer.parseInt(Console.readLine());

        System.out.println("\n당첨 통계\n---");

        List<Integer> correctLotto = new ArrayList<Integer>();
        for (Lotto l : lottos) {       // separate
            int count = 0;
            for (int p : prizeNum) {
                if (l.getNumbers().contains(p)) {
                    count++;
                }
            }
            if (count == 5) {           // separate
                if (l.getNumbers().contains(bonusNum)) {
                    count += 100;
                }
            }
            correctLotto.add(count);
        }

        System.out.println(prizeStatus.THREE.getNum() + "개 일치 (" + prizeStatus.THREE.getPrice() + ") - " + Collections.frequency(correctLotto, 3) + "개");
        System.out.println(prizeStatus.FOUR.getNum() + "개 일치 (" + prizeStatus.FOUR.getPrice() + ") - " + Collections.frequency(correctLotto, 4) + "개");
        System.out.println(prizeStatus.FIVE.getNum() + "개 일치 (" + prizeStatus.FIVE.getPrice() + ") - " + Collections.frequency(correctLotto, 5) + "개");
        System.out.println(prizeStatus.FIVEBONUS.getNum() + "개 일치 (" + prizeStatus.FIVEBONUS.getPrice() + ") - " + Collections.frequency(correctLotto, 105) + "개");
        System.out.println(prizeStatus.SIX.getNum() + "개 일치 (" + prizeStatus.SIX.getPrice() + ") - " + Collections.frequency(correctLotto, 6) + "개");

    }
}

