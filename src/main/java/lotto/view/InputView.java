package lotto.view;

import java.util.List;

public interface InputView {
    int readPurchaseAmount();

    List<Integer> readWinningNumbers();

    int readBonusNumber();
}
