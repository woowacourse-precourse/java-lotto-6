package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("[");

        String numberList = numbers.stream()
                .map(element -> element.toString())
                .collect(Collectors.joining(", "));

        msg.append(numberList).append("]");
        return msg.toString();
    }

    public LottoResult getLottoResult(List<Integer> winningNumberList, Integer bonusNum) {
        LottoResult[] resultMapper = {
                LottoResult.OTHER,
                LottoResult.OTHER,
                LottoResult.OTHER,
                LottoResult.MATCH3,
                LottoResult.MATCH4,
                LottoResult.MATCH5,
                LottoResult.MATCH6
        };
        LottoResult result = resultMapper[checkWinningCount(winningNumberList)];
        if (result == LottoResult.MATCH5 && checkBonusNumber(bonusNum)){
            result = LottoResult.MATCH5_AND_BONUS;
        }
        return result;
    }

    private Integer checkWinningCount(List<Integer> winningNumberList) {
        Integer count = 0;
        for (Integer num : numbers) {
            if (winningNumberList.contains(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean checkBonusNumber(Integer bonusNum) {
        return numbers.contains(bonusNum);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 정확히 6자리여야 합니다.");
        }
        for (Integer num : numbers) {
            if (num < 1 || num > 45)
                throw new IllegalArgumentException("각 로또번호는 1 ~ 45 사이의 정수여야 합니다.");
        }
        Set<Integer> distinctList = new HashSet<>(numbers);
        if (numbers.size() != distinctList.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    // TODO: 추가 기능 구현
}
