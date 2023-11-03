package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int matchNumberCount = 0;
    private boolean matchBonusCount;
    private int prize;

    public int getMatchNumberCount() {
        return matchNumberCount;
    }

    public void setMatchNumberCount(int matchNumberCount) {
        this.matchNumberCount = matchNumberCount;
    }

    public boolean isMatchBonusCount() {
        return matchBonusCount;
    }

    public void setMatchBonusCount(boolean matchBonusCount) {
        this.matchBonusCount = matchBonusCount;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
//        validateDuplicateNumber(numbers);
//        validateNumberRange(numbers)
        this.numbers = numbers;
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void printLottoNumbers() {
        System.out.println(numbers.toString());
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
