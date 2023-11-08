package lotto.view;

import java.util.List;

public interface InputView {
    int enterPurchaseAmount();

    List<Integer> enterWinningLottoNumbers();

    int enterBonusLottoNumber();
}
