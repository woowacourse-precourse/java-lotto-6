package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoCompare {
    private static final int ONE_COUNT = 1;
    private static final int DEFAULT_COUNT = 0;
    private final Map<WinningGrade, Integer> winningMap = new EnumMap<>(WinningGrade.class);

    public LottoCompare() {
        init();
    }

    private void init() {
        Arrays.stream(WinningGrade.values())
                .forEach(value -> winningMap.put(value, DEFAULT_COUNT));
    }

    public void compareAllLottoToWinning(List<List<Integer>> lottos, WinningNumbers winningNumbers) {
        lottos.forEach(lotto -> compareLottoToWinning(lotto, winningNumbers));
    }

    public Map<WinningGrade, Integer> getWinningResult() {
        return new EnumMap<>(winningMap);
    }

    private void compareLottoToWinning(List<Integer> lotto, WinningNumbers winningNumbers) {
        int matchCount = getMatchCount(lotto, winningNumbers);
        boolean bonusIncluded = hasBonusNumber(lotto, winningNumbers);
        findWinningGrade(matchCount, bonusIncluded);
    }

    private void findWinningGrade(int matchCount, boolean bonusIncluded) {
        WinningGrade grade = WinningGrade.findGrade(matchCount, bonusIncluded);
        addWinningGradeResult(grade);
    }

    private void addWinningGradeResult(WinningGrade grade) {
        int onePlusCount = winningMap.get(grade) + ONE_COUNT;
        winningMap.put(grade, onePlusCount);
    }

    private boolean hasBonusNumber(List<Integer> lotto, WinningNumbers winningNumbers) {
        return winningNumbers.hasBonusNumber(lotto);
    }

    private int getMatchCount(List<Integer> lotto, WinningNumbers winningNumbers) {
        return (int) lotto.stream().filter(winningNumbers::contains).count();
    }
}
