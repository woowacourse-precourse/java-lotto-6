package lotto.parser;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.validator.InputBonusValidator;
import lotto.view.LottoInputView;
public class BonusNumberParser {
    public static BonusNumber parse(Lotto winningLotto, String bonusNumber) {
        try{
            InputBonusValidator.validateBonus(winningLotto, bonusNumber);
        }catch(IllegalArgumentException e){
            return parse(winningLotto, LottoInputView.requestInputBonusNumber());
        }
        return new BonusNumber(Integer.parseInt(bonusNumber));
    }
}
