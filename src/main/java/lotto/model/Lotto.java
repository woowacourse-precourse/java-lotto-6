package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public static int profit = 0;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) { // HashSet의 add 메서드는 중복되는 경우 false를 반환합니다.
                throw new IllegalArgumentException();
            }
        }
    }

    public void calculateWinningPrize(Lotto winnerLotto, int bonusNumber, LottoRankRecorder recorder) {
        profit += Judgement.getPrizeAmount(winnerLotto, this, bonusNumber, recorder);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    @Override
    public String toString() {
        String lottoToString = "[";
        int number;
        for (int i = 0; i < 5; i++) {
            number = this.numbers.get(i);
            lottoToString += number + ", ";
        }
        lottoToString += this.numbers.get(5) + "]";
        return lottoToString;
    }
}
