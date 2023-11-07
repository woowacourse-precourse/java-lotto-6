package lotto.domain;

import static lotto.validator.LottoNumberValidator.validate_MIN_SIZE;

import java.util.List;
import lotto.validator.LottoNumberValidator;
import lotto.validator.NumberValidator;

public class WinningLotto {
    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers){
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers){validate_MIN_SIZE(numbers);}
    public List<Integer> getWinning_number(){
        return this.numbers;
    }

    public void addBonusNumber(String bonus_number){
        NumberValidator.validate(bonus_number);
        getWinning_number().add(Integer.parseInt(bonus_number));
        LottoNumberValidator.validate_MAX_SIZE(getWinning_number());
    }

}
