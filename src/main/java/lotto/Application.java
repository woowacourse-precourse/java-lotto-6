package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
            // TODO: 프로그램 구현
            final int LOTTO_PRICE = 1000;

            // 기능1. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 1장 당 1000원의 로또를 발행해야 한다.
            // 1000원으로 나눠 떨어지지 않는 경우 예외처리를 한다.
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());

            List<Lotto> lottos = null;
            try {
                // buyLottos 메서드를 구현하여 1000원으로 나눠떨어지지 않는 경우 IllegalArgumentException을 발생시키도록 함.
                lottos = Lotto.buyLottos(amount);
                System.out.println(amount / LOTTO_PRICE + "개를 구매했습니다.");

            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]");
            }

            lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
            // 기능2. 당첨 번호와 보너스 번호를 입력받는다.
            System.out.print("\n당첨 번호를 입력해 주세요.\n");
            String line = Console.readLine();
            String[] numberStrings = line.split(",");
            List<Integer> winningNumbers = new ArrayList<>();
            String[] winningNumberStrings = new String[0];
            for (String number : winningNumberStrings) {
                winningNumbers.add(Integer.parseInt(number.trim()));
            }
            // 기능2. 당첨 번호와 보너스 번호를 입력받는다.
            System.out.print("보너스 번호를 입력해 주세요.\n");
            int bonusNumber = Integer.parseInt(Console.readLine());

            // 기능3. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
            System.out.println("\n당첨 통계");
            System.out.println("---");
            Map<Integer, Integer> results = new TreeMap<>();
            // 3개 일치 (5,000원), 4개 일치 (50,000원), 5개 일치 (1,500,000원), 5개 일치, 보너스 볼 일치 (30,000,000원), 6개 일치 (2,000,000,000원)
            int[] prizes = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};

            lottos.forEach(lotto -> {
                int matchCount = lotto.numOfMatches(winningNumbers);
                boolean bonusMatch = lotto.hasBonusNumber(bonusNumber);
                int key = matchCount;
                if (matchCount == 5 && bonusMatch) key = 7;

                results.put(key, results.getOrDefault(key, 0) + 1);
            });

            int total = 0;
            // 기능3. 당첨 내역 출력
            for (int i = 3; i <= 5; i++) {
                    int count = results.getOrDefault(i, 0);
                    total += prizes[i] * count;
                    System.out.printf("%d개 일치 (%s원)- %d개\n", i, String.format("%, d", prizes[i]), count);
            }
            int countBonus = results.getOrDefault(7, 0);
            total += prizes[7] * countBonus;
            System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개\n", String.format("%,d", prizes[6]), countBonus);
            System.out.printf("6개 일치 (%s원) - %d개\n", String.format("%,d", prizes[7]), results.getOrDefault(6, 0));
            // 기능3. 수익률 출력
            double profitRate = ((double) total / amount) * 100;
            System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
            // 기능3. 로또 게임 종료 - main  메서드의 마지막 부분이므로 프로그램 종료됨
    }
}
