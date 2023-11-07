package lotto.parser;

import lotto.exception.DuplicatedNumberException;
import lotto.exception.EmptyException;
import lotto.exception.InvalidLottoFormatException;
import lotto.exception.InvalidLottoNumberRangeException;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.validator.InputBonusValidator;
import lotto.view.LottoView;

public class BonusNumberParser {
    public static BonusNumber parse(Lotto winningLotto, String bonusNumber) {
        try{
            InputBonusValidator.validateBonus(winningLotto, bonusNumber);
        }catch(EmptyException| InvalidLottoFormatException| InvalidLottoNumberRangeException| DuplicatedNumberException e){
            return parse(winningLotto, LottoView.requestInputBonusNumber());
        }
        return new BonusNumber(Integer.parseInt(bonusNumber));
    }
}
