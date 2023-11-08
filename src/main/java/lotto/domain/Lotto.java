package lotto.domain;

import java.util.List;

import lotto.global.Prize;
import lotto.global.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Prize compare(List<Integer> lottoNumber, Integer bonusNumber) {
        Integer winCount = this.numbers.stream()
                .filter(number -> lottoNumber.contains(number)).toList().size();
        Boolean hasBonusNumber = lottoNumber.contains(bonusNumber);
        
        return LottoCondition.getRank(winCount, hasBonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkNumberCount(numbers);
        Validator.checkAllInRange(numbers);
        Validator.checkDuplicate(numbers);
    }
}
