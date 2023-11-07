package lotto.controller;

import lotto.domain.BonusLottoNumber;
import lotto.domain.Lotto;

import java.util.List;

public interface LottoGetterInterface {
    int getLottoTicket(int money);

    List<Lotto> getLottoNumber(int tickets);

    BonusLottoNumber getBounsNumber(int bouns);

    String getLottoString();
}
