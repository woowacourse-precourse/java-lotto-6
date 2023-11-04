package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoWinnerSystem {

    private List<Integer> winNumbers;

    public List<Integer> isValidWinNumber(String input) {
        try {
            List<Integer> numbers = convertIntegerList(input);

            this.winNumbers = numbers;
            return numbers;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    private List<Integer> convertIntegerList(String input) {
        List<Integer> numbers = Stream.of(input.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        return numbers;
    }

    private static void isValidLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 숫자를 6개를 입력해 주세요.");
        }
    }

    private static void isDistinct(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자입니다.");
        }
    }

    private static void isValidRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 1 && numbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 1-45 이내의 숫자를 입력해 주세요.");
            }
        }
    }
}
