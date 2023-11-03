package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Integer> winningCount = new ArrayList<>();
    private final List<Boolean> hasBonusNumber = new ArrayList<>();

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public void addWinningCount(int count) {
        winningCount.add(count);
    }

    public void checkBonusNumberMatched(boolean isBonusNumber) {
        hasBonusNumber.add(isBonusNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningCount() {
        return winningCount;
    }

    public List<Boolean> getHasBonusNumber() {
        return hasBonusNumber;
    }

    public String getPurchaseDetails() {
        StringBuilder purchasedLottos = new StringBuilder();

        for (Lotto lotto : lottos) {
            purchasedLottos.append(lotto.getNumbers()).append("\n");
        }

        return purchasedLottos.toString();
    }
}
