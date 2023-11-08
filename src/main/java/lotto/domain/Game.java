package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constant.Rank;
import lotto.util.Generator;

public class Game {
    private List<Lotto> userLottos;
    private Lotto winnerNumber;
    private BonusNumber bonusNumber;

    public void generateUserLottos(int amount) {
        this.userLottos = IntStream.range(0, amount)
                .mapToObj(i -> new Lotto(Generator.generateRandomNumbers()))
                .collect(Collectors.toList());
    }

    public void generateWinnerNumber(String winnerNumber) {
        this.winnerNumber = new Lotto(winnerNumber);
    }

    public void generateBonusNumber(String bonusNumber) {
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public Map<Rank, Integer> compare() {
        Map<Rank, Integer> results = new HashMap<>();
        initResults(results);
        createResults(results);
        return results;
    }

    private void initResults(Map<Rank, Integer> results) {
        for (Rank rank : Rank.values()) {
            results.put(rank, 0);
        }
    }

    private void createResults(Map<Rank, Integer> results) {
        for (Lotto userLotto : userLottos) {
            int matchedNum = userLotto.compareNumbers(winnerNumber.getNumbers());
            boolean isMatchBonus = userLotto.compareOneNumber(bonusNumber.getBonus());
            Rank rank = Rank.valueOf(matchedNum, isMatchBonus);
            results.put(rank, results.get(rank) + 1);
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(userLottos);
    }
}
