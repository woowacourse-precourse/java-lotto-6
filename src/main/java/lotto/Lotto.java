package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    //Lotto 객체를 생성하기 전에 모든 검증을 완료하므로 validate 메소드 삭제했지만 테스트 코드 확인 후 수정
    private void validate(List<Integer> numbers) {
        Set<Integer> checkDuplicate = new HashSet<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        for (Integer number : numbers) {
            if (!checkDuplicate.add(number)) {
                throw new IllegalArgumentException("중복된 번호가 있습니다: ");
            }
        }
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (int number : this.numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean bonusNumberMatch(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
