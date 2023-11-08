package lotto.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import lotto.Lotto;
import java.util.ArrayList;


public class LottoGame {

    private static final Map<Integer, BiFunction<Integer, Boolean, Integer>> rankDecider = new HashMap<>();
    private static final Map<Integer, Integer> prizeMoneyMap = new HashMap<>();

    static {
        // 각 등수에 대한 상금 매핑 초기화
        prizeMoneyMap.put(1, 2_000_000_000); // 1등 상금
        prizeMoneyMap.put(2, 30_000_000);    // 2등 상금
        prizeMoneyMap.put(3, 1_500_000);     // 3등 상금
        prizeMoneyMap.put(4, 50_000);        // 4등 상금
        prizeMoneyMap.put(5, 5_000);         // 5등 상금
    }
    public static int determineRank(int matchCount, boolean hasBonus) {
        if (matchCount < 3) {
            return 0; // 당첨되지 않음
        }
        if (matchCount == 3) {
            return 5;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 5) {
            if (hasBonus) {
                return 2; // 5개 일치, 보너스 볼 일치
            }
            return 3; // 5개 일치
        }
        if (matchCount == 6) {
            return 1; // 6개 일치
        }
        return 0; // 그 외 경우
    }


    public static List<Integer> convertInputToIntegerList(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public static Map<Integer, Integer> getPrizeMoneyMap() {
        return prizeMoneyMap;
    }



    public static List<Lotto> generatePurchasedLotto(int numberOfPurchasedLottos) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < numberOfPurchasedLottos; i++) {
            Lotto purchasedLotto = Lotto.generate();
            purchasedLottos.add(purchasedLotto);
        }
        return purchasedLottos;
    }



    private static int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        uniqueNumbers.retainAll(winningNumbers);
        return uniqueNumbers.size();
    }

    private static int getRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = getMatchCount(lotto.getNumbers(), winningNumbers);
        boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

        return determineRank(matchCount, hasBonus);
    }

    public static Map<Integer, Integer> calculateWinningsStats(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Integer, Integer> winningsStats = new HashMap<>();

        // 각 등수별로 초기화
        for (int i = 0; i <= 5; i++) { // 0: 당첨되지 않음, 1~5: 5등부터 1등까지
            winningsStats.put(i, 0);
        }

        // 모든 로또에 대해 반복하면서 등수별로 횟수 계산
        for (Lotto lotto : purchasedLottos) {
            int rank = getRank(lotto, winningNumbers, bonusNumber);
            winningsStats.put(rank, winningsStats.get(rank) + 1);
        }

        return winningsStats;
    }



    public static long calculateTotalWinnings(Map<Integer, Integer> winningsStats) {
        long totalWinnings = 0;
        for (Map.Entry<Integer, Integer> entry : winningsStats.entrySet()) {
            totalWinnings += (long) prizeMoneyMap.getOrDefault(entry.getKey(), 0) * entry.getValue();
        }
        return totalWinnings;
    }


}
