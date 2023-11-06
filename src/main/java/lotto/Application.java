package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //List<Integer> lottoNum = new ArrayList<>();
        //Lotto lotto = new Lotto(lottoNum);

        System.out.println("구입금액을 입력해 주세요.");
        String price_Str = Console.readLine();
        int price = Integer.parseInt(price_Str);
        if (price % 1000 != 0) throw new IllegalArgumentException("금액을 잘 못 입력함");
        int LottoPurchase = price / 1000;

        List<List<Integer>> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < LottoPurchase; ++i ) {
            purchasedLotto.add(buy_lotto());

        }
        System.out.printf("\n%d개를 구매했습니다.\n", LottoPurchase);
        for (int i = 0; i < LottoPurchase; ++i) System.out.println(purchasedLotto.get(i));

        //예외
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        List<String> winningList = Arrays.asList(winningNumber.split(","));
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNum = Console.readLine();

        int[] winning = new int[5];
        System.out.println("\n당첨 통계\n---");
        checkWinning(winningList, purchasedLotto, winning, Integer.parseInt(bonusNum));
        System.out.printf(
                "3개 일치 (5,000원) - %d개\n" +
                "4개 일치 (50,000원) - %d개\n" +
                "5개 일치 (1,500,000원) - %d개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
                "6개 일치 (2,000,000,000원) - %d개\n", winning[0], winning[1], winning[2], winning[3], winning[4]);
        double revenue = winning[0] * 5000 + winning[1] * 50000 + winning[2] * 1500000 + winning[3] * 30000000 + winning[4] * 2000000000;
        System.out.println("총 수익률은 " + revenue * 100 / price + "%입니다");
    }

    public static void checkWinning(List<String> winningList, List<List<Integer>> purchasedLotto, int[] winning, int bonusNum) {
        int cnt;
        for (List<Integer> lotto : purchasedLotto) {
            cnt = 0;
            for (int j = 0; j < 6; ++j) {
                if (lotto.contains(Integer.parseInt(winningList.get(j)))) cnt++;
            }
            if (cnt == 6) {
                winning[4] += 1;
                continue;
            }
            if (lotto.contains(bonusNum)) {
                cnt++;
            }

            if (cnt - 3 >= 0) {
                winning[cnt - 3] += 1;
            }
        }
    }

    public static List<Integer> buy_lotto() {
        List<Integer> list = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            int num;
            do {
                num = Randoms.pickNumberInRange(1, 45);
            } while (uniqueNumbers.contains(num));
            list.add(num);
            uniqueNumbers.add(num);
        }
        Collections.sort(list);
        return list;
    }

}
