package lotto.service;

import lotto.domain.Player;

public class LottoService {

    public Player createPlayer(int purchaseAmount) {
        return new Player(purchaseAmount);
    }




}
