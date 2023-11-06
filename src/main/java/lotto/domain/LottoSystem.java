package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.util.RandomUtil;

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

    public Lotto generateWinningLotto() {
        return Lotto.create(RandomUtil.generateRandomLottoNumber());
    }

    public int getPurchasedLottoCount() {
        return player.getPurchasedLottoCount();
    }
}
