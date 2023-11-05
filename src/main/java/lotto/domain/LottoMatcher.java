package lotto.domain;

public class LottoMatcher {

    private long correctWinningCount;
    private boolean correctBonus;

    public LottoMatcher(Lotto userNumbers, Lotto winningNumber) {
        this.correctWinningCount = calculateCorrectWinning(userNumbers, winningNumber);
    }

    public LottoMatcher(Lotto userNumbers, Lotto winningNumber, int bonusNumber) {
        this.correctWinningCount = calculateCorrectWinning(userNumbers, winningNumber);
        this.correctBonus = calculateCorrectBonus(userNumbers, bonusNumber);
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
}
