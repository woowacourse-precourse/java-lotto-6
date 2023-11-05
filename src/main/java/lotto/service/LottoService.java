package lotto.service;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class LottoService {
    private final Amount amount;
    private final BonusLotto bonusLotto;
    private final Lotto lotto;
    private final UserLotto userLotto;
    private ConcurrentHashMap<List<Integer>, Winning> winngResult;

    public LottoService(Amount amount, UserLotto userLotto, Lotto lotto, BonusLotto bonusLotto) {
        this. amount = amount;
        this.userLotto = userLotto;
        this.lotto = lotto;
        this.bonusLotto = bonusLotto;
    }
    public void compareLottoNumber() {
        winngResult = countEqualNumber();

        for (Map.Entry<List<Integer>, Winning> entry : winngResult.entrySet()) {
            if(entry.getValue().getEqualCount().equals(5)) {
                entry.getValue().updateBonus(entry.getKey(), bonusLotto.getBonusNumber());
            }
        }
    }

    private ConcurrentHashMap<List<Integer>, Winning> countEqualNumber() {
        List<Long> equalCounts = new ArrayList<>();

        for (List<Integer> userNumbers : userLotto.getUserNumbers()) {
            equalCounts.add(userNumbers.stream().filter(u -> lotto.getNumbers().stream()
                            .anyMatch(Predicate.isEqual(u)))
                    .count());
        }
        WinningResult winningResult = new WinningResult(userLotto, equalCounts);

        return winningResult.getWinngResult();
    }
}
