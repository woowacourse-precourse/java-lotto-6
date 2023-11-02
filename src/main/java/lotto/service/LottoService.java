package lotto.service;

import lotto.domain.Player;
import lotto.domain.WinningLotto;

import java.util.List;

public class LottoService {

    public Player createPlayer(int purchaseAmount) {
        return new Player(purchaseAmount);
    }

    public WinningLotto createWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningLotto(winningNumbers, bonusNumber);
    }




}
