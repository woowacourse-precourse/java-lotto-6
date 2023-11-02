package lotto.domain;

import lotto.validator.LottoValidator;

import java.util.List;

public class MyLottos {
    public List<Lotto> lottos;
    public MyLottos(String amount){
        LottoValidator.amountInputValidator(amount);
    }
}
