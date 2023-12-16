package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    private final Map<Rank, Integer> result;
    private List<Lotto> lottos;

    public Computer() {
        result = new HashMap<>();
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public void generateLottos(Money money) {
        int count = money.getLottoCount();
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = LottoMachine.generateLotto();
            lottos.add(lotto);
        }
    }

    public String getLottos() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto).append("\n");
        }
        return sb.toString();
    }

    public void check(WinningLotto winningLotto) {
        lottos.forEach(lotto -> {
            Rank.getRank(winningLotto, lotto).ifPresent(
                    rank -> {
                        int count = result.get(rank);
                        result.put(rank, ++count);
                    }
            );
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : Rank.values()) {
            sb.append(String.format(rank.getMessage(), result.get(rank))).append("\n");
        }
        return sb.toString();
    }

    public BigDecimal calculatePercent(Money money) {
        BigDecimal sum = new BigDecimal("0");
        for (Rank rank : Rank.values()) {
            sum = sum.add(rank.getPrize().multiply(new BigDecimal(result.get(rank))));
        }
        return sum.divide(new BigDecimal(money.getPrice())).multiply(new BigDecimal("100"));
    }
}
