package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final Integer LOTTO_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 로또는 6개의 숫자로 구성되야합니다");
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.stream()
                   .collect(
                        Collectors.toSet()
                    )
                   .size()
                != LOTTO_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자로 이루어진 로또를 생성할 수 없습니다.");
        }
    }

    public LottoResult compareWithWinnerLotto(List<Integer> winnerNumbers, Integer bonusNumber) {
        Integer countOfSameNumbers = compareWithWinnerNumbers(winnerNumbers);
        Boolean checkBonus = compareWithBonusNumber(bonusNumber);

        return new LottoResult(countOfSameNumbers, checkBonus);
    }


    private Integer compareWithWinnerNumbers(List<Integer> winnerNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(number -> winnerNumbers.contains(number))
                .count());
    }

    private Boolean compareWithBonusNumber(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    public String toString() {
        Collections.sort(numbers);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        for (Integer number : numbers) {
            stringBuilder.append(number);
            stringBuilder.append(",");
            stringBuilder.append(" ");
        }

        stringBuilder.replace(
                stringBuilder.length()-2,
                     stringBuilder.length(),
                    "]");

        return stringBuilder.toString();
    }
}
