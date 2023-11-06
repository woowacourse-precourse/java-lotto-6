package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final List<Lotto> lottos = new ArrayList<>();
        final GameService gameService = new GameService();
        HashMap<Integer,Integer> winningList = new HashMap<>();
        winningList.put(3, 0);
        winningList.put(4, 0);
        winningList.put(5, 0);
        winningList.put(6, 0);
        winningList.put(9, 0);

        System.out.println("구입금액을 입력해 주세요.");
        int purchasePrice = Integer.parseInt(Console.readLine());
        int buyLottoCount = purchasePrice / 1000;
        System.out.println();

        System.out.printf("%d개를 구매했습니다.%n", buyLottoCount);
        for(int i = 0; i < buyLottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lotto.printLottoNumber();
            lottos.add(lotto);
        }
        System.out.println();

        System.out.println("당첨 번호를 입력해 주세요.");
        int[] winningNumbers = Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();

        for(Lotto lotto : lottos) {
            int winningCount = lotto.checkWinning(winningNumbers, bonusNumber);
            if(winningCount > 2) {
                winningList.put(winningCount, winningList.get(winningCount) + 1);
            }
        }
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", winningList.get(3));
        System.out.printf("4개 일치 (50,000원) - %d개%n", winningList.get(4));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", winningList.get(5));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", winningList.get(9));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", winningList.get(6));

        int profit = gameService.getProfit(winningList);
        System.out.printf("총 수익률은 %.1f%%입니다.%n", gameService.calculateYields(purchasePrice, profit));
    }

}
