package lotto.domain;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessages;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> NumbersWithDuplicatesRemove = new HashSet<>(numbers);
        if (NumbersWithDuplicatesRemove.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NOT_A_MULTIPLE_OF_1000.getMessage());
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NOT_SIX_NUMBERS.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public void printLottoNumbers() {
        System.out.println(this.numbers);
    }

    public int compareWithTheCorrectAnswer(List<Integer> answer) {
        int matchedNumberCount = 0;
        for (int i = 0; i < 6; i++) {
            if (answer.contains(this.numbers.get(i))) {
                matchedNumberCount++;
            }
        }
        return matchedNumberCount;
    }

    public boolean compareWithBonusNumber(int bonus){
        return this.numbers.contains(bonus);
    }
}
