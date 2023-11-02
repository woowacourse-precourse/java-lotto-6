package lotto.service;

import lotto.domain.User;

public class LottoService {
    public User buyLotto(long inputPurchaseAmount){
        return User.create(inputPurchaseAmount);
    }
}
