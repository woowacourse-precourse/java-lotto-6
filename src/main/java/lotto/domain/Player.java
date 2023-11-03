package lotto.domain;

import lotto.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final int FIRST = 2_000_000_000,
            SECOND = 30_000_000,
            THIRD = 1_500_000,
            FORTH = 50_000,
            FIFTH = 5_000;
    private int money, prize;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Integer, Integer> results = new HashMap<>();

    public Player(int money) {
        this.money = money;
    }

    public void issueLotto() {
        int lottoSize = money / 1_000;
        // TODO : lottos 사이즈와 lottoSize 비교
        for (int i = 0; i < lottoSize; i++) {
            lottos.add(new Lotto(RandomGenerator.generate()));
        }
    }

    public void sortLottos() {
        for (Lotto lotto : lottos) {
            lotto.sort();
        }
    }

    public void findResults(Lotto winningLotto) {

    }

    private int findRank(int count, boolean bonus) {
        return -1;
    }

    public String issuedLottos() {
        StringBuilder result = new StringBuilder(lottos.size()).append("개를 구매했습니다.\n");
        for (Lotto lotto : lottos) {
            result.append(lotto.toString()).append('\n');
        }
        return result.toString();
    }

    public String lottoResults() {
        return "";
    }
}
