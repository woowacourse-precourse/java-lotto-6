package lotto.userLotto.domain;

import static java.util.Collections.sort;
import static lotto.util.LottoConstant.LOTTO_SIZE;

import java.util.List;
import lotto.util.LottoConstant;
import lotto.winningLotto.domain.LottoBonusNumber;

public class Lotto {


    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateBlank(numbers);
        validateSize(numbers);
        validateDuplicated(numbers);
        validateOutOfRangeOneToFortyFive(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getLotto(){
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public boolean contains(LottoBonusNumber bonusNumber){
        return numbers.contains(bonusNumber.getNumber());
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != duplicatedSize(numbers);
    }

    private Long duplicatedSize(List<Integer> numbers) {
        return numbers.stream().distinct().count();
    }

    private void validateBlank(List<Integer> numbers) {
        if (numbers == null) {
            throw new NullPointerException();
        }
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateOutOfRangeOneToFortyFive(List<Integer> numbers) {
        for (int number : numbers) {
            checkOutOfRangeRangeOneToFortyFive(number);
        }
    }

    private void checkOutOfRangeRangeOneToFortyFive(int number) {
        if (number < LottoConstant.BEGIN_NUMBER || number > LottoConstant.LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }



}
