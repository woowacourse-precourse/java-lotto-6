package lotto.Exception;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoListException {

    final int lottoLength = 6;

    public List<Integer> checkSelectedNumber(String initialNumbers) {
        List<Integer> numbers = checkInt(initialNumbers);
        checkPositive(numbers);
        checkLenght(numbers);
        checkDouble(numbers);

        return numbers;
    }

    public List<Integer> checkInt(String initialNumbers) {
        try {
            List<Integer> numbers = Arrays.stream(initialNumbers.split(","))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해주세요.");
        }
    }

    public void checkPositive(List<Integer> numbers) {
        for(int number : numbers) {
            if (number < 1 && number > 45) {
                throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자를 입력해주세요.");
            }
        }
    }

    public void checkLenght(List<Integer> numbers) {
        if (numbers.size() != lottoLength) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자를 입력해주세요.");
        }
    }

    public void checkDouble(List<Integer> numbers) {
        Set<Integer> validateNumbers = new HashSet<>(numbers);

        if (numbers.size() != validateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 숫자가 중복되었습니다.");
        }
    }

}
