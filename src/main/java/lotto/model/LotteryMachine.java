package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.enums.WinningMoney;

public class LotteryMachine {

    private Map<WinningMoney, Integer> store;

    private PersonLotto personLotto;

    private WinningLotto winningLotto;

    public LotteryMachine(PersonLotto personLotto, WinningLotto winningLotto) {
        this.store = new EnumMap<>(WinningMoney.class);
        this.personLotto = personLotto;
        this.winningLotto = winningLotto;
    }

    public Map<WinningMoney, Integer> drawingLotto(Bonus bonus) {
        personLotto.getPurchaseLotto().forEach(
                lotto -> {
                    int matchCount = checkMatch(lotto);
                    WinningMoney result = WinningMoney.from(matchCount, checkBonus(lotto, bonus));
                    store.put(result, store.getOrDefault(result, 0) + 1);
                }
        );
        return store;
    }

    private int checkMatch(Lotto lotto) {
        List<Integer> purchasedLotto = lotto.getNumbers();
        purchasedLotto.retainAll(winningLotto.getWinningNumbers());
        return purchasedLotto.size();
    }

    private boolean checkBonus(Lotto lotto, Bonus bonus) {
        return lotto.getNumbers().contains(bonus.getBonusNumber());
    }
}
