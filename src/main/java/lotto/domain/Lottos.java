package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Integer> winningNumber;
    private final int bonusNumber;
    private Player player;

    public Lottos(List<Integer> winningNumber, int bonusNumber, Player player) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.player = player;
    }
}
