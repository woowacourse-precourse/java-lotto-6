package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class LottoValidator {
    public static void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateNumberRange(numbers);
        validateUniqueNumber(numbers);
    }

    private static void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개입니다.");
        }
    }

    private static void validateNumberRange(List<Integer> numbers) {
        for(int number : numbers){
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }
}
