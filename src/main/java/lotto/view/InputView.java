package lotto.view;

import java.util.List;

public interface InputView {
    List<Integer> insertWinningNumbers();
    int insertBonusNumber(List<Integer> winningNumbers);
    int insertMoney();
}
