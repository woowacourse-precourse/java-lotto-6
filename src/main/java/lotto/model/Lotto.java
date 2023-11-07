package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.StringConstant;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.constant.NumberConstant.*;
import static lotto.message.ErrorMessage.EXIST_DUPLICATE;
import static lotto.message.ErrorMessage.INVALID_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.value()) {
            throw new IllegalArgumentException(INVALID_SIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_START_INCLUSIVE.value(), LOTTO_NUMBER_END_INCLUSIVE.value(), LOTTO_SIZE.value());
        return new Lotto(numbers);
    }

    public String joinNumbersWithDelimiter(StringConstant stringConstant) {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(stringConstant.value()));
    }

    private void validateDuplicate(List<Integer> numbers){
        Set<Integer> numberSet = new HashSet<>(numbers);
        if(numberSet.size()!= LOTTO_SIZE.value()){
            throw new IllegalArgumentException(EXIST_DUPLICATE.getMessage());
        }
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

}
