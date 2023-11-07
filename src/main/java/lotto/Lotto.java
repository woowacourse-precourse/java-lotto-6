package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        validate(sortedNumbers);
        validateNumber(sortedNumbers);
        checkDuplicate(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리의 숫자여야합니다.");
        }
    }

    private void validateNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 로또번호를 입력해야 합니다.");
            }
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> checkSet = new HashSet<>();
        for (Integer number : numbers) {
            if (checkSet.contains(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 서로 중복되면 안됩니다.");
            }
            checkSet.add(number);
        }
    }
    public List<Integer> getNumbers(){
        return this.numbers;
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    // TODO: 추가 기능 구현
}
