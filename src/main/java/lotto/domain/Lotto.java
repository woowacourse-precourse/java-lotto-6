package lotto.domain;

import lotto.contants.OutputEnum;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumberSize(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(OutputEnum.output.ERR_LOTTO_MUST_BE_SIX_NUMBER.getDescription());
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers){
        if(numbers.stream().anyMatch(it -> it > 45)){
            throw new IllegalArgumentException(OutputEnum.output.ERR_LOTTO_NOT_IN_RANGE.getDescription());
        }
    }

    private void validateLottoNumberDuplicated(List<Integer> numbers){
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size()!=numbers.size()){
            throw new IllegalArgumentException(OutputEnum.output.ERR_LOTTO_DUPLICATED.getDescription());
        }
    }

    public void validateBonusNumberRange(int number){
        if(number>45){
            throw new IllegalArgumentException(OutputEnum.output.ERR_BONUS_NOT_IN_RANGE.getDescription());
        }
    }

    public void validateBonusNumberDuplicated(int number){
        if(numbers.stream().anyMatch(it -> it.equals(number))){
            throw new IllegalArgumentException(OutputEnum.output.ERR_BONUS_DUPLICATED.getDescription());
        }
    }


}
