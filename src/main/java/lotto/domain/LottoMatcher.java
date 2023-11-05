package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcher {

    private long correctWinningCount;
    private boolean correctBonus;
    private List<Long> correctWinningsCount = new ArrayList<>();
    private List<Boolean> correctBonuses = new ArrayList<>();

    public LottoMatcher(Lotto userNumbers, Lotto winningNumber) {
        this.correctWinningCount = calculateCorrectWinning(userNumbers, winningNumber);
    }

    public LottoMatcher(Lotto userNumbers, Lotto winningNumber, int bonusNumber) {
        this.correctWinningCount = calculateCorrectWinning(userNumbers, winningNumber);
        this.correctBonus = calculateCorrectBonus(userNumbers, bonusNumber);
    }

    public LottoMatcher(List<Lotto> userNumbers, Lotto winningNumber, int bonusNumber) {
        for (Lotto userNumber : userNumbers) {
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

    public long calculateCorrectWinning(Lotto userNumbers, Lotto winningNumbers) {
        long correctCount = userNumbers.getLottoNumbers().stream()
                .filter(userNumber -> winningNumbers.getLottoNumbers().contains(userNumber))
                .count();

        return correctCount;
    }

    public boolean calculateCorrectBonus(Lotto userNumbers, int bonusNumber) {
        return userNumbers.getLottoNumbers().contains(bonusNumber);
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
