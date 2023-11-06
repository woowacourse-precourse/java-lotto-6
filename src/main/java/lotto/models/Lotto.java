package lotto.models;

import lotto.valid.LottoValidator;

import java.util.List;

public class Lotto {

    // 새 필드를 추가할 수 없다
    // 필드의 접근 제어자를 변경할 수 없다
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.validate(numbers);
    }

    public LottoGrade calcRank(WinNumber winNumber) {
        int matchCount = countMatchNumbers(winNumber);
        boolean matchBonus = isMatchBonus(winNumber);

        if (matchCount == 6) {
            return LottoGrade.FIRST;
        }
        if (matchCount == 5 && matchBonus) {
            return LottoGrade.SECOND;
        }
        if (matchCount == 5) {
            return LottoGrade.THIRD;
        }
        if (matchCount == 4) {
            return LottoGrade.FOURTH;
        }
        if (matchCount == 3) {
            return LottoGrade.FIFTH;
        }

        return LottoGrade.NONE;
    }

    private boolean isMatchBonus(WinNumber winNumber) {
        return numbers.contains(winNumber.getBonusNumber());
    }

    private int countMatchNumbers(WinNumber winNumber) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winNumber.getLotto().getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return String.join(", ", numbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
