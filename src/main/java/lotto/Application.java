package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.LottoRank.*;

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
        
        Map<LottoRank, Integer> result = new HashMap<>();
        
        for (Lotto lotto : lottos) {
            LottoRank rank = winningLotto.rank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        
        printResult(result);
    }
    
    private static void printResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        
        printRankResult(FIFTH, result);
        printRankResult(FOURTH, result);
        printRankResult(THIRD, result);
        printRankResult(SECOND, result);
        printRankResult(FIRST, result);
        
        String profitRate = calculateProfitRate(result);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
    
    private static void printRankResult(LottoRank rank, Map<LottoRank, Integer> result) {
        System.out.println(rank.getCountOfMatch()
            + "개 일치"
            + (rank == SECOND ? ", 보너스 볼 일치 " : " ")
            + "(" + String.format("%,d", rank.getWinningMoney()) + "원) - "
            + result.getOrDefault(rank, 0) + "개");
    }
    
    private static String calculateProfitRate(Map<LottoRank, Integer> result) {
        int totalPrizeMoney = result.entrySet().stream()
            .mapToInt(entry -> entry.getKey().getWinningMoney() * entry.getValue())
            .sum();
        
        int purchaseAmount = result.values().stream().mapToInt(Integer::intValue).sum() * 1000;
        
        double profitRate = (double) totalPrizeMoney / purchaseAmount * 100;
        
        DecimalFormat df = new DecimalFormat("0.#");
        return df.format(profitRate);
    }
    
}
