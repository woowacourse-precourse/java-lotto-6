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

    private Optional<Prize> getPrize(int totalMatchingNumberCount, boolean hasBonusNumber) {
        if (totalMatchingNumberCount == 6 && hasBonusNumber) {
            return Optional.of(Prize.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH);
        }

        return Arrays.stream(Prize.values())
                .filter(prize -> prize.getMatchingNumberCount() == totalMatchingNumberCount)
                .findAny();
    }

    private int getMatchingNumberCount(Lotto winningLotto) {
        return (int) winningLotto.getLottoNumbers()
                .stream()
                .filter(winningLottoNumber ->
                        player.getLotto().getLottoNumbers()
                                .stream()
                                .anyMatch(lottoNumber -> isNumberMatch(lottoNumber.getLottoNumber(), winningLottoNumber.getLottoNumber())))
                .count();
    }

    private int getMatchingBonusNumberCount(Lotto winningLotto) {
        return (int) winningLotto.getLottoNumbers()
                .stream()
                .filter(winningLottoNumber -> isNumberMatch(player.getBonusNumber(), winningLottoNumber.getLottoNumber()))
                .count();
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
