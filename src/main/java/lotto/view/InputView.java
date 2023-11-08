package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.List;

public interface InputView {

    Money readUserPurchaseMoney();

    List<LottoNumber> readWinnerLottoNumbers();

    LottoNumber readBonusNumber();
}
