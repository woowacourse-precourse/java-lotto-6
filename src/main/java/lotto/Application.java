package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
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
        return money;
    }

    private static int getLottoCount(int m) {
        System.out.println("\n" + m / 1000 + "개를 구매했습니다.");
        return m / 1000;
    }

    private static int getPrizeCount(List<Integer> lottoMatch, int num) {
        return Collections.frequency(lottoMatch, num);
    }

    public static void main(String[] args) {
        int money = inputPurchaseMoney();
        int lottoCount = getLottoCount(money);


        // TODO: 여기부터 모듈화
        List<Lotto> lottos = new ArrayList<Lotto>();

        for (int i = 0; i < lottoCount; i++) {
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

        List<Integer> lottoMatchCount = new ArrayList<Integer>();
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
            lottoMatchCount.add(count);
        }

        DecimalFormat df = new DecimalFormat("###,###");

        int earn = 0;
        System.out.println(prizeStatus.THREE.getNum() + "개 일치 ("
                + df.format(prizeStatus.THREE.getPrice()) + "원) - " + getPrizeCount(lottoMatchCount, 3) + "개");
        earn += prizeStatus.THREE.getPrice() * getPrizeCount(lottoMatchCount, 3);

        System.out.println(prizeStatus.FOUR.getNum() + "개 일치 ("
                + df.format(prizeStatus.FOUR.getPrice()) + "원) - " + getPrizeCount(lottoMatchCount, 4) + "개");
        earn += prizeStatus.FOUR.getPrice() * getPrizeCount(lottoMatchCount, 4);

        System.out.println(prizeStatus.FIVE.getNum() + "개 일치 ("
                + df.format(prizeStatus.FIVE.getPrice()) + "원) - " + getPrizeCount(lottoMatchCount, 5) + "개");
        earn += prizeStatus.FIVE.getPrice() * getPrizeCount(lottoMatchCount, 5);

        System.out.println(prizeStatus.FIVEBONUS.getNum() + "개 일치, 보너스 볼 일치 ("
                + df.format(prizeStatus.FIVEBONUS.getPrice()) + "원) - " + getPrizeCount(lottoMatchCount, 105) + "개");
        earn += prizeStatus.FIVEBONUS.getPrice() * getPrizeCount(lottoMatchCount, 105);

        System.out.println(prizeStatus.SIX.getNum() + "개 일치 ("
                + df.format(prizeStatus.SIX.getPrice()) + "원) - " + getPrizeCount(lottoMatchCount, 6) + "개");
        earn += prizeStatus.SIX.getPrice() * getPrizeCount(lottoMatchCount, 6);


        // 수익률 = 당첨금 / 구입금 * 100) -> 5000/8000 = 0.625 * 100 = 62.5%
        float earningRate = ((float) earn / money) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate);

    }
}

