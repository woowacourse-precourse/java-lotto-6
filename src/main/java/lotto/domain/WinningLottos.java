package main.java.lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningLottos {

    private List<Lotto> winningLottos;

    public WinningLottos(List<Lotto> winningLottos) {

        this.winningLottos = winningLottos;
    }

    public List<Lotto> getWiningLottos() {
        return winningLottos;
    }
}