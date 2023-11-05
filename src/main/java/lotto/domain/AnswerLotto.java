package lotto.domain;

import java.util.List;

public class AnswerLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public AnswerLotto(List<Integer> numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.lotto = new Lotto(numbers);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        validateNumberCount(numbers);
        validateDuplicateNumbers(numbers, bonusNumber);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers, int bonusNumber) {
        validateNumbers(numbers);
        validateWithBonusNumber(numbers, bonusNumber);
    }

    private void validateNumbers(List<Integer> numbers) {
        int nonDuplicatedCount = (int) numbers.stream().distinct().count();
        if (nonDuplicatedCount != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateWithBonusNumber(List<Integer> numbers, int bonusNumber) {
        boolean isDuplicated = numbers.stream()
                .filter(number -> number.equals(bonusNumber))
                .findFirst().isPresent();
        if (isDuplicated) {
            throw new IllegalArgumentException();
        }
    }

    public Ranking calculateWinningResult(Lotto userLotto) {
        // 당첨 번호에서 비교
        int matchCount = userLotto.compareToAnswerLotto(lotto);

        // 보너스 번호 비교
        boolean containBonusBall = userLotto.compareToBonusNumber(bonusNumber.getBonusNumber());

        return Ranking.getRanking(matchCount, containBonusBall);
    }
}
