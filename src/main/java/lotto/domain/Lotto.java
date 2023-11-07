package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        List<Integer> randomNums = issueLotto();
        validate(randomNums);
        numbers = randomNums;
    }

    private void validate(List<Integer> numbers) {
        validateCountNums(numbers);
        validateRange(numbers);
        validateDuplicatedNum(numbers);
    }

    private void validateDuplicatedNum(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (int i=0; i<6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateCountNums(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> issueLotto() {
        List<Integer> randomNums = new ArrayList<>();
        while (randomNums.size() < 6) {
            int num = Randoms.pickNumberInRange(1, 45);
            if (!randomNums.contains(num)) {
                randomNums.add(num);
            }
        }
        sortLotto(randomNums);
        return randomNums;
    }

    private void sortLotto(List<Integer> lottoNums) {
        Collections.sort(lottoNums);
    }

    public int compareWithLotto(WinningLotto winningLotto) {
        List<Integer> winningSixLottoNums = winningLotto.getLotto().getNumbers();
        int equalCount = 0;
        for (int i=0; i<6; i++) {
            if (numbers.contains(winningSixLottoNums.get(i))) {
                equalCount++;
            }
        }
        return equalCount;
    }

    public boolean compareWithBonusNum(WinningLotto winningLotto) {
        if (numbers.contains(winningLotto.getBonusNum())) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return numbers.toString();
    }
}
