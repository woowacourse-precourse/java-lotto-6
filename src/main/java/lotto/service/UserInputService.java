package lotto.service;

import lotto.domain.Lotto;

public interface UserInputService {
    int payForLotto();
    void userInputLottoNum();
    boolean isValidate(int num);
    Lotto createLotto();
}
