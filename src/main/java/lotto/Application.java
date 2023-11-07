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
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        
        Map<Integer, Integer> matchCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            int count = lotto.countMatchedNumbers(winningLotto.getLotto());
            matchCount.put(count, matchCount.getOrDefault(count, 0) + 1);
        }
        
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5,000원)- " + matchCount.getOrDefault(3, 0) + "개");
        System.out.println("4개 일치 (50,000원)- " + matchCount.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원)- " + matchCount.getOrDefault(5, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원)- " + matchCount.getOrDefault(6, 0) + "개");
    }
}

