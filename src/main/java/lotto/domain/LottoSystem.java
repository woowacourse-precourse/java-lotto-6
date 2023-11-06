package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.util.RandomUtil;

import java.util.ArrayList;
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

    public List<Lotto> generateWinningLottos() {
        List<Lotto> winningLottos = new ArrayList<>();
        for (int i = 0; i < player.getPurchasedLottoCount(); i++) {
            winningLottos.add(generateWinningLotto());
        }
        return winningLottos;
    }

    private Lotto generateWinningLotto() {
        return Lotto.create(RandomUtil.generateRandomLottoNumber());
    }

    private int getPurchasedLottoCount() {
        return player.getPurchasedLottoCount();
    }
}
