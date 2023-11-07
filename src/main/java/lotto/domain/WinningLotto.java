package lotto.domain;

import static lotto.validator.LottoNumberValidator.validate_MIN_SIZE;

import java.util.List;
import lotto.validator.LottoNumberValidator;
import lotto.validator.NumberValidator;

public class WinningLotto {
    private final List<Integer> lottoNumbers;

    public WinningLotto(List<Integer> lottoNumbers){
        validate_MIN_SIZE(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getWinning_number(){
        return this.lottoNumbers;
    }

    public void addBonusNumber(String bonus_number){
        NumberValidator.validate(bonus_number);
        getWinning_number().add(Integer.parseInt(bonus_number));
        LottoNumberValidator.validate_MAX_SIZE(getWinning_number());
    }

}
