package lotto.domain;

import static lotto.utils.ConstantString.NEW_LINE;
import static lotto.utils.ConstantValues.DEFAULT_COUNT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int count = 0; count < purchaseAmount.getAvailableLottoCount(); count++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
    }

    public int getCount() {
        return lottos.size();
    }

    public Map<Prize, Integer> getWinningResult(WinnigMachine winnigMachine) {
        Map<Prize, Integer> winningResult = new HashMap<>();
        for (Lotto lotto : lottos) {
            Prize prize = winnigMachine.getPrize(lotto);
            if (prize.equals(Prize.NO_PRIZE)) {
                continue;
            }
            Integer prizeCount = winningResult.getOrDefault(prize, DEFAULT_COUNT);
            prizeCount++;
            winningResult.put(prize, prizeCount);
        }
        return winningResult;
    }

    @Override
    public String toString() {
        StringJoiner lottosPrinting = new StringJoiner(NEW_LINE);
        for (Lotto lotto : lottos) {
            lottosPrinting.add(lotto.toString());
        }
        return lottosPrinting.toString();
    }
}
