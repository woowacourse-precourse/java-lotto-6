package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {
    int payForLotto();
    void userInputLottoNum();
    boolean isValidate(int num);
    Lotto createLotto();
}
