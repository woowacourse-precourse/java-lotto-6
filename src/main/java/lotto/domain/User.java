package lotto.domain;

import java.util.List;

public class User {
    private final int numberOfLottoPapers;
    private final List<Lotto> lottos;

    public User(int numberOfLottoPapers, List<Lotto> lottos) {
        this.numberOfLottoPapers = numberOfLottoPapers;
        this.lottos = lottos;
    }

    public int getNumberOfLottoPapers() {
        return numberOfLottoPapers;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
