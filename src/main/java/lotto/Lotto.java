package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

import static lotto.LottoRank.*;

public class Lotto {
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

    // TODO: 추가 기능 구현
    public void printNumbers() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        getSortedNumber().forEach(number -> stringJoiner.add(number + ""));
        System.out.println("[" + stringJoiner + "]");
    }

    private List<Integer> getSortedNumber() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public LottoRank getRank(Lotto winningLotto, int bonusNumber) {
        long numberScore = this.numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
        if (numberScore == 6)
            return FIRST;
        else if (numberScore == 5 && this.numbers.contains(bonusNumber))
            return SECOND;
        else if (numberScore == 5)
            return THIRD;
        else if (numberScore == 4)
            return FORTH;
        else if (numberScore == 3)
            return FIFTH;
        return SIXTH;
    }
}
