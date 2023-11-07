package lotto.domain;

import java.util.List;
import lotto.validator.LottoNumberValidator;
import lotto.validator.NumberValidator;
import lotto.vo.WinningLottoNumbers;

public class WinningLotto {
    private final WinningLottoNumbers lottoNumbers;
    private final static int DELETE_INDEX = 6;

    public WinningLotto(List<Integer> lottoNumbers){
        this.lottoNumbers = new WinningLottoNumbers(lottoNumbers);
    }

    public List<Integer> getWinning_number(){
        return this.lottoNumbers.value();
    }

    public void addBonusNumber(String bonus_number){
        NumberValidator.validate(bonus_number);
        getWinning_number().add(Integer.parseInt(bonus_number));
        LottoNumberValidator.validate_MAX_SIZE(getWinning_number());
    }

}
