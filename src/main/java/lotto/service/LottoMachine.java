package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.model.Coin;
import lotto.model.Lotto;
import lotto.model.LottoPaper;
import lotto.model.LottoStats;
import lotto.model.PlayerNumber;
import lotto.model.Rank;

public class LottoMachine {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final int COUNT_NUMBER = 6;
    private final int INIT_NUMBER = 0;
    private List<Lotto> lottos;
    private LinkedHashMap<Rank, Integer> stats;
    private Coin coin;
    public LottoMachine() {
        lottos = new ArrayList<>();
        stats = new LinkedHashMap<>();
    }


    public List<LottoPaper> publishLottoPaper(Coin coin) {
        this.coin = coin;

        for(int i = 0; i < coin.getCount(); i++) {
            generateLotto();
        }

        return lottos.stream()
                .map(lotto -> new LottoPaper(lotto.getNumbers()))
                .collect(Collectors.toList());
    }

    private void generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_NUMBER,
                MAX_NUMBER,
                COUNT_NUMBER);

        lottos.add(new Lotto(numbers));
    }

    public LottoStats compareLotto(PlayerNumber player) {
        initStats();

        for(Lotto lotto : lottos) {
            Rank rank = lotto.compare(player);
            stats.put(rank, stats.get(rank) + 1);
        }

        return new LottoStats(stats);
    }

    private void initStats() {
        for (Rank rank : Rank.values()) {
            stats.put(rank, INIT_NUMBER);
        }
    }

    public double calculateBenefitRate() {
        double amount = coin.getAmount();
        double benefit = calculateBenefit();

        return benefit / amount * 100;
    }

    private double calculateBenefit() {
        double benefit = 0.0;

        for (Entry<Rank, Integer> stat : stats.entrySet()) {
            benefit += stat.getKey().getPrice() * stat.getValue();
        }

        return benefit;
    }
}
