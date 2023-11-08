package lotto.service;

import java.util.List;

public interface WinningService {

    void createWinningLotto(List<Integer> winningNumber);

    void createBonusNumber(int bonusNumber);
}
