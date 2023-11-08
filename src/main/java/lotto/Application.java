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
        int purchaseAmount = requestPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        List<Lotto> lottos = lottoMachine.purchaseLottos();
        
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        
        List<Integer> winningNumbers = requestWinningNumbers();
        int bonusBall = requestBonusBall();
        
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        
        Map<LottoRank, Integer> result = new HashMap<>();
        
        for (Lotto lotto : lottos) {
            LottoRank rank = winningLotto.rank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        
        printResult(result);
    }
    
    private static int requestPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }
    
    private static List<Integer> requestWinningNumbers() {
        while (true) {
            try {
                System.out.println("지난 주 당첨 번호를 입력해 주세요.");
                return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
    }
    
    private static int requestBonusBall() {
        while (true) {
            try {
                System.out.println("보너스 볼을 입력해 주세요.");
                return Integer.parseInt(Console.readLine());
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            }
        }
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
