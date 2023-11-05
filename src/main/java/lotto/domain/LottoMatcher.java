package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcher {

    private long correctWinningCount;
    private boolean correctBonus;
    private List<Long> correctWinningsCount = new ArrayList<>();
    private List<Boolean> correctBonuses = new ArrayList<>();

    public LottoMatcher(List<Integer> userNumbers, List<Integer> winningNumber) {
        this.correctWinningCount = calculateCorrectWinning(userNumbers, winningNumber);
    }

    public LottoMatcher(List<Integer> userNumbers, List<Integer> winningNumber, int bonusNumber) {
        this.correctWinningCount = calculateCorrectWinning(userNumbers, winningNumber);
        this.correctBonus = calculateCorrectBonus(userNumbers, bonusNumber);
    }

    public LottoMatcher(List<List<Integer>> userNumbers, List<Integer> winningNumber, int bonusNumber) {
        for(List<Integer> userNumber: userNumbers) {
            long winning = calculateCorrectWinning(userNumber, winningNumber);
            boolean bonus = calculateCorrectBonus(userNumber, bonusNumber);

            correctBonuses.add(bonus);
            if(bonus) {
                correctWinningsCount.add(winning + 1);
                continue;
            }

            correctWinningsCount.add(winning);
        }
    }

    public long calculateCorrectWinning(List<Integer> userNumbers, List<Integer> winningNumbers) {
        long correctCount = userNumbers.stream()
                .filter(userNumber -> winningNumbers.contains(userNumber))
                .count();

        return correctCount;
    }

    public boolean calculateCorrectBonus(List<Integer> userNumbers, int bonusNumber) {
        return userNumbers.contains(bonusNumber);
    }

    public long getCorrectWinningCount() {
        return this.correctWinningCount;
    }

    public long getAllCorrectCount() {
        long allCorrectCount = 0;

        if (isCorrectBonus()) {
            allCorrectCount += 1;
        }

        allCorrectCount += this.correctWinningCount;
        return allCorrectCount;
    }

    public boolean isCorrectBonus() {
        return this.correctBonus;
    }

    public List<Long> getCorrectWinningsCount() {
        return correctWinningsCount;
    }

    public List<Boolean> getCorrectBonuses() {
        return correctBonuses;
    }
}
