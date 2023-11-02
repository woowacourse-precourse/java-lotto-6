package lotto.service;

import lotto.domain.User;

public class LottoService {
    public User buyLotto(String inputPurchaseAmount){
        return User.create(inputPurchaseAmount);
    }
}
