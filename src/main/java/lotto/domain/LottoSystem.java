package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.player.Player;

import java.util.List;

public class LottoSystem {

    private List<Lotto> winningLottos;
    private Player player;

    private LottoSystem(List<Lotto> winningLottos, Player player) {
        this.winningLottos = winningLottos;
        this.player = player;
    }

    public static LottoSystem create(List<Lotto> winningLottos, Player player) {
        return new LottoSystem(winningLottos, player);
    }
}
