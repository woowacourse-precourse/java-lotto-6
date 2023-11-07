package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.player.Player;
import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private boolean hasBonusNumber(Lotto winningLotto) {
        return winningLotto.getLottoNumbers()
                .stream()
                .anyMatch(lottoNumber -> isNumberMatch(lottoNumber.getLottoNumber(), player.getBonusNumber()));
    }

    private boolean isNumberMatch(Integer number1, Integer number2) {
        return Objects.equals(number1, number2);
    }
}
