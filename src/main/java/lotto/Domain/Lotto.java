package lotto.Domain;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;


public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers); // 중복을 확인하고 나서 복사본을 저장
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MSG_LENGTH);
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MSG_DUPLICATED);
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public static Lotto generateRandomLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    public List<Integer> getSortedNumbers() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }


}


