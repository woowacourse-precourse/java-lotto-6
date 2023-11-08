package lotto.controller.inputCreator;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.view.InputBonusNumberView;

public class BonusNumberController implements ObjectCreator<BonusNumber, Lotto> {

    @Override
    public BonusNumber createObjectByInput(Lotto lotto) {
        int number = InputBonusNumberView.inputBonusNumber();
        return new BonusNumber(lotto, number);
    }
}
