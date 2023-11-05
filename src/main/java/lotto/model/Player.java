package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.utils.Generator;

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

    public int getAmount() {
        return playerAmount.getAmount();
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    private static List<Lotto> purchaseLotto(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(Generator.generateLottoNumbers()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player\n");
        sb.append("구입한 로또 수량: ").append(playerAmount.getAmount()).append("\n");
        sb.append("구입한 로또:\n");
        for (int i = 0; i < lotto.size(); i++) {
            sb.append("로또 ").append(i + 1).append(": ").append(lotto.get(i)).append("\n");
        }
        return sb.toString();
    }
}
