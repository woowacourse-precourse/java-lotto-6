package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constans.WinningGrade;

public class LottoMachine {

    public List<Lotto> makeLottos(int wantBuyQuantity) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < wantBuyQuantity; i++) {
            lottos.add(makeLotto());
        }

        return lottos;
    }

    public int wantBuyAmountToQuantity(int wantBuyAmount) {
        return wantBuyAmount / 1000;
    }

    private Lotto makeLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    private int countCorrespond(Lotto lotto, List<Integer> winningNumber) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumber::contains)
                .count();
    }

    private WinningGrade findGrade(Lotto lotto, List<Integer> winningNumber, int bonusNumber) {
        int countCorrespond = countCorrespond(lotto, winningNumber);
        if (countCorrespond > 2) {
            return WinningGrade.findWinningGrade(countCorrespond, containBonusNumber(lotto, bonusNumber));
        }
        return null;
    }

    private boolean containBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Map<WinningGrade, Integer> makeResultMap(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        Map<WinningGrade, Integer> map = initializeResultMap();
        for (Lotto lotto : lottos) {
            WinningGrade winningGrade = findGrade(lotto, winningNumber, bonusNumber);
            if (winningGrade != null) {
                map.put(winningGrade, map.getOrDefault(winningGrade, 0) + 1);
            }
        }

        return map;
    }

    private Map<WinningGrade, Integer> initializeResultMap() {
        Map<WinningGrade, Integer> map = new HashMap<>();
        map.put(WinningGrade.FIFTH_PRIZE,0);
        map.put(WinningGrade.FOURTH_PRIZE,0);
        map.put(WinningGrade.THIRD_PRIZE,0);
        map.put(WinningGrade.SECOND_PRIZE, 0);
        map.put(WinningGrade.FIRST_PRIZE, 0);
        return map;
    }

    private WinningGrade[] winningGradeSortByRank() {
        WinningGrade[] values = WinningGrade.values();
        Arrays.sort(values, Comparator.comparingInt(WinningGrade::getRank).reversed());

        return values;
    }

    public String makeResult(Map<WinningGrade,Integer> resultMap,int wantBuyAmount) {
        WinningGrade[] winningGrades = winningGradeSortByRank();
        long totalIncome = calculationTotalIncome(resultMap);
        double yields = calculationYields(wantBuyAmount, totalIncome);
        StringBuilder sb = new StringBuilder();

        for (WinningGrade winningGrade : winningGrades) {
            sb.append(mapResultToString(winningGrade, resultMap.get(winningGrade))).append("\n");
        }

        sb.append("총 수익률은 ").append(yields).append("%입니다.\n");
        return sb.toString();

    }

    private String mapResultToString(WinningGrade winningGrade, int value) {
        StringBuilder sb = new StringBuilder();
        sb.append(winningGrade.getMessage()).append(value).append("개");

        return sb.toString();
    }

    private long calculationTotalIncome(Map<WinningGrade,Integer> resultMap) {
        long totalIncom = 0;
        for (WinningGrade winningGrade : resultMap.keySet()) {
            totalIncom += ((long) winningGrade.getPrizeMoney() * resultMap.get(winningGrade));
        }

        return totalIncom;
    }

    private double calculationYields(int wantBuyAmount, long totalIncome) {
        double yields = (double) totalIncome / (double) wantBuyAmount;
        return (double) Math.round(yields * 1000) / 10;
    }

}
