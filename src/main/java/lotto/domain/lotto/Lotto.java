package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import lotto.domain.number.LottoNumber;
import lotto.global.enums.ErrorMessage;
import lotto.global.exception.InvalidValueException;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private List<LottoNumber> numbers = new ArrayList<>();

    public static Lotto forUserLotto(List<LottoNumber> lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    public static Lotto raffle(List<LottoNumber> numbers){
        return new Lotto(numbers);
    }

    public void addBonusNumber(LottoNumber lottoNumber){
        validateDuplicateBonusNumber(lottoNumber);
        this.numbers.add(lottoNumber);
    }

    public List<LottoNumber> getNumbers(){
        return this.numbers;
    }

    public LottoNumber getBonusNumber(){
        return this.numbers.stream()
                .filter(LottoNumber::isBonus)
                .findFirst().get();
    }

    private Lotto(List<LottoNumber> numbers) {
        validateDuplicateNumber(numbers);
        validateNumberSize(numbers);
        this.numbers.addAll(numbers);
    }

    private void validateDuplicateNumber(List<LottoNumber> lottoNumbers){
        if (this.numbers.contains(Set.of(lottoNumbers).size() != LOTTO_NUMBERS_SIZE)){
            throw new InvalidValueException(ErrorMessage.DUPLICATED_NUMBER_VALUE);
        }
    };
    private void validateDuplicateBonusNumber(LottoNumber lottoNumber){
        if (this.numbers.contains(lottoNumber)){
            throw new InvalidValueException(ErrorMessage.DUPLICATED_NUMBER_VALUE);
        }
    }

    private void validateNumberSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
    @Override
    public String toString(){
        return numbers.toString();
    }

}
