package lotto.models;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoGrade calcRank(WinningNumber winningNumber) {
        int matchCount = countMatchNumbers(winningNumber);
        boolean matchBonus = isMatchBonus(winningNumber);

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

    private boolean isMatchBonus(WinningNumber winningNumber) {
        return numbers.contains(winningNumber.getBonusNumber());
    }

    private int countMatchNumbers(WinningNumber winningNumber) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winningNumber.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

}
