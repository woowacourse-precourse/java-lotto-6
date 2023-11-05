package lotto.domain;

public class LottoMatcher {

    private long correctWinningCount;

    public LottoMatcher(Lotto userNumbers, Lotto winningNumber) {
        this.correctWinningCount = calculateCorrectWinning(userNumbers, winningNumber);
    }

    public long calculateCorrectWinning(Lotto userNumbers, Lotto winningNumbers) {
        long correctCount = userNumbers.getLottoNumbers().stream()
                .filter(userNumber -> winningNumbers.getLottoNumbers().contains(userNumber))
                .count();

        return correctCount;
    }

    public long getCorrectWinningCount() {
        return this.correctWinningCount;
    }
}
