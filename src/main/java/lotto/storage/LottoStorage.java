package lotto.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lotto.domain.Lotto;

public class LottoStorage {
    private final List<Lotto> lotteries;

    public LottoStorage() {
        this.lotteries = new ArrayList<>();
    }

    public Lotto saveLotto(Lotto lotto) {
        lotteries.add(lotto);
        return lotto;
    }

    public List<Lotto> findAllBoughtLotteries() {
        return lotteries.stream()
                .filter(lotto -> !lotto.isJackpotLotto())
                .toList();
    }

    public Optional<Lotto> findJackpot() {
        return lotteries.stream()
                .filter(Lotto::isJackpotLotto)
                .findFirst();
    }
}
