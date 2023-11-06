package lotto.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LottoValidator {
    private boolean isNotSizeSix(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    public void checkSize(List<Integer> numbers) {
        if (isNotSizeSix(numbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자는 6개만 입력하세요.");
        }
    }

    private boolean isNotInRange(List<Integer> numbers) {
        Optional<Integer> notRangeNum = numbers.stream()
                .filter(number -> 1 > number || number > 45)
                .findAny();

        if (notRangeNum.isPresent()) {
            return true;
        }
        return false;
    }

    public void checkRange(List<Integer> numbers) {
        if(isNotInRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 입력 가능한 로또 숫자 범위는 1 ~ 45입니다.");
        }
    }

    private boolean isDuplicateWinningNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return numbers.size() != uniqueNumbers.size();
    }

    public void checkDuplicateWinningNumbers(List<Integer> numbers) {
        if(isDuplicateWinningNumbers(numbers)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호 입력에 중복된 숫자를 넣지마세요.");
        }
    }
}
