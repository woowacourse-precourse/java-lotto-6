package lotto.domain;

public record Result(int matchWinningNumbers, boolean matchBonusNumber) {

    @Override
    public String toString() {
        return "{" + matchWinningNumbers +
                ", " + matchBonusNumber +
                '}';
    }
}
