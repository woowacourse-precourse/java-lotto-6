package lotto.domain.lotto;

import lotto.service.dto.LottoResultDto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public LottoResultDto matchWithWinningNumbersAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        int matchedAmount = getMatchedAmount(winningNumbers);
        int bonusMatchedAmount = getBonusMatchedAmount(bonusNumber);

        return new LottoResultDto(matchedAmount, bonusMatchedAmount);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 입력되지 않았습니다.");
        }

        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자로 구성되었습니다.");
        }
    }

    private int getMatchedAmount(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private int getBonusMatchedAmount(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return 1;
        }
        return 0;
    }
}
