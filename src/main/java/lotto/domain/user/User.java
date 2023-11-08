package lotto.domain.user;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;
import lotto.domain.lotto.SaleLotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.shop.Shop;

public class User {
    private int spendingMoney = 0;
    private List<SaleLotto> lottos;
    private final EnumMap<Rank, Integer> rankCount = new EnumMap<>(Rank.class);
    private long prize = 0;

    public User() {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankCount.put(rank, 0));
    }

    public void buyLotto(int price, Shop shop) {
        spendingMoney += price;
        lottos = shop.sellLotto(price);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public void checkLottoResult(WinningLotto winningLotto) {
        lottos.stream()
                .map(lotto -> lotto.checkLottoRank(winningLotto))
                .forEach(this::addRankCount);
    }

    private void addRankCount(Rank rank) {
        rankCount.put(rank, rankCount.get(rank) + 1);
        prize += rank.getPrize();
    }

    public double getProfitRate() {
        return (double)prize / spendingMoney * 100;
    }

    public Map<Rank, Integer> getRankCount() {
        return Collections.unmodifiableMap(rankCount);
    }

    public long getPrize() {
        return prize;
    }
}
