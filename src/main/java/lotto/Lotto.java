package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private Integer resultRank;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개를 입력해주세요.");
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

    }

    public void setResultRank(Integer rank) {
        this.resultRank = rank;
    }

    public void printNumbers() {
        System.out.println(numbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getResultRank() {
        return resultRank;
    }
}
