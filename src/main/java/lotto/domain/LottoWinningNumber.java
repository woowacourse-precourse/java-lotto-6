package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

public class LottoWinningNumber {

    private List<Integer> numbers;

    public LottoWinningNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>();

        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);

        for (int i = 0; i < numbers.size(); ++i) {
            int number = numbers.get(i);
            validNumber(number);
            this.numbers.add(number);
        }
        this.numbers = numbers;
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();

        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }


    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 " + LottoConstant.LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    private void validNumber(int number) {
        if (number < LottoConstant.LOTTO_START_NUMBER || number > LottoConstant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(
                    "당첨 번호는 " + LottoConstant.LOTTO_START_NUMBER + " 이상, "
                            + LottoConstant.LOTTO_END_NUMBER + " 이하여야 합니다.");
        }
    }

    public boolean containsNumber(int number) {
        if (numbers.contains(number)) {
            return true;
        }

        return false;
    }
}
