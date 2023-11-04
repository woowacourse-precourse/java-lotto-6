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
}
