package lotto.service;

import lotto.domain.LuckyLotto;

public interface UserInputService {
    int payForLotto();
    void userInputLottoNum();
    boolean isValidate(int num);
    LuckyLotto createLotto();
}
