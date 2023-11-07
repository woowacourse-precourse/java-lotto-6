package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        List<Lotto> lottos = lottoMachine.purchaseLottos();
        
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusBall = Integer.parseInt(Console.readLine());
        
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        
        Map<String, Integer> matchCount = new HashMap<>();
        matchCount.put("3개 일치 (5,000원)", 0);
        matchCount.put("4개 일치 (50,000원)", 0);
        matchCount.put("5개 일치 (1,500,000원)", 0);
        matchCount.put("5개 일치, 보너스 볼 일치(30,000,000원)", 0);
        matchCount.put("6개 일치 (2,000,000,000원)", 0);
        
        for (Lotto lotto : lottos) {
            int count = lotto.countMatchedNumbers(winningLotto.getLotto());
            if (count == 6) {
                matchCount.put("6개 일치 (2,000,000,000원)", matchCount.get("6개 일치 (2,000,000,000원)") + 1);
            } else if (count == 5) {
                if (winningLotto.isSecondRank(lotto)) {
                    matchCount.put("5개 일치, 보너스 볼 일치(30,000,000원)", matchCount.get("5개 일치, 보너스 볼 일치(30,000,000원)") + 1);
                } else {
                    matchCount.put("5개 일치 (1,500,000원)", matchCount.get("5개 일치 (1,500,000원)") + 1);
                }
            } else if (count == 4) {
                matchCount.put("4개 일치 (50,000원)", matchCount.get("4개 일치 (50,000원)") + 1);
            } else if (count == 3) {
                matchCount.put("3개 일치 (5,000원)", matchCount.get("3개 일치 (5,000원)") + 1);
            }
        }
        
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원)- " + matchCount.get("3개 일치 (5,000원)") + "개");
        System.out.println("4개 일치 (50,000원)- " + matchCount.get("4개 일치 (50,000원)") + "개");
        System.out.println("5개 일치 (1,500,000원)- " + matchCount.get("5개 일치 (1,500,000원)") + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30,000,000원)- " + matchCount.get("5개 일치, 보너스 볼 일치(30,000,000원)") + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + matchCount.get("6개 일치 (2,000,000,000원)") + "개");
    }
}
