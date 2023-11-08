package lotto.service;

import lotto.domain.CustomerLotto;
import lotto.domain.Lotto;

public interface UserInputService {
    int payForLotto();
    void userInputLottoNum();
    boolean isValidate(int num);
    CustomerLotto createLotto();
}
