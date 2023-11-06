package lotto.model.lotto;

import static lotto.utils.Generator.generateSortedLottoNumbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {
    private final PlayerAmount playerAmount;
    private final List<Lotto> lotto;

    private Player(PlayerAmount playerAmount, List<Lotto> lotto) {
        this.playerAmount = playerAmount;
        this.lotto = lotto;
    }

    public static Player from(PlayerAmount playerAmount) {
        List<Lotto> lotto = purchaseLotto(playerAmount.getAmount());
        return new Player(playerAmount, lotto);
    }

    private static List<Lotto> purchaseLotto(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(generateSortedLottoNumbers()))
                .collect(Collectors.toList());
    }

    public int getPlayerAmount() {
        return playerAmount.getAmount();
    }

    public List<Lotto> getPlayerLotto() {
        return lotto;
    }
}
