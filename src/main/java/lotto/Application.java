package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String price_Str;
        boolean validInput = false;
        int price = 0;

        do {
            price_Str = Console.readLine();
            try {
                price = Integer.parseInt(price_Str);
                if (price % 1000 != 0) {
                    throw new IllegalArgumentException();
                }
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 값 입력, 다시 입력해 주세요.");
            }
        } while (!validInput);
        int LottoPurchase = price / 1000;

        List<Lotto> purchasedLotto = new ArrayList<>();
        buy_lotto(purchasedLotto, LottoPurchase);

        System.out.printf("\n%d개를 구매했습니다.\n", LottoPurchase);
        for (int i = 0; i < LottoPurchase; ++i) {
            System.out.println(purchasedLotto.get(i).getNumbers());
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumber = Console.readLine();
        List<Integer> winningList = Arrays.stream(winningNumber.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        checkNum(winningList);
        Lotto winningNumbers = new Lotto(winningList);

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        int bonusNum = Integer.parseInt(bonus);
        if (bonusNum < 1 || bonusNum > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        int[] winning = new int[5];
        checkWinning(winningNumbers, purchasedLotto, winning, bonusNum);
        winningStatic(price, winning);
    }

    public static void buy_lotto(List<Lotto> purchasedLotto, int LottoPurchase) {
        for (int i = 0; i < LottoPurchase; ++i ) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            purchasedLotto.add(lotto);
        }
    }

    public static void checkNum(List<Integer> LootoNum) {
        for (int num : LootoNum) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static void checkWinning(Lotto winningNumbers, List<Lotto> purchasedLotto, int[] winning, int bonusNum) {
        int cnt;
        for (Lotto lotto : purchasedLotto) {
            cnt = 0;
            for (int j = 0; j < 6; ++j) {
                if (lotto.contains(winningNumbers.get(j))) cnt++;
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

    public static void winningStatic(int price, int[] winning) {
        System.out.printf("""
                        당첨 통계
                        ---
                        3개 일치 (5,000원) - %d개
                        4개 일치 (50,000원) - %d개
                        5개 일치 (1,500,000원) - %d개
                        5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                        6개 일치 (2,000,000,000원) - %d개
                        """, winning[0], winning[1], winning[2], winning[3], winning[4]);
        double revenue = winning[0] * 5000 + winning[1] * 50000 + winning[2] * 1500000 + winning[3] * 30000000 + winning[4] * 2000000000;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", Math.round(revenue * 100 / price * 10) / 10.0);
    }
}
