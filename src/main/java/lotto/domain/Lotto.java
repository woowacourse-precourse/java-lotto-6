package lotto.domain;

import static lotto.enums.ErrorMessage.INVALID_PURCHASE_NUMBER_FORMAT;
import static lotto.enums.LottoCalculateNums.LOTTO_COUNT;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(INVALID_PURCHASE_NUMBER_FORMAT.getType());
        }
        if(numbers.stream().distinct().count() != LOTTO_COUNT){
            throw new IllegalArgumentException(INVALID_PURCHASE_NUMBER_FORMAT.getType());
        }
    }

    public LottoResult matchLotto(List<Integer> winningNumber, int bonusNumber){

        int matchedCnt = (int)numbers.stream().filter(num -> winningNumber.stream().anyMatch(Predicate.isEqual(num))).count();
        boolean isBonus = numbers.stream().anyMatch(Predicate.isEqual(bonusNumber));
        LottoResult lottoResult = new LottoResult(matchedCnt, isBonus);

        return lottoResult;
    }

}
