package lotto.Domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Enum.WinningType;

public class Human {
    private List<Lotto> lottos = new ArrayList<>();
    private Map<WinningType, Integer> winningResult;
    private Long budget;
    private Long reward = 0L;

    public Human(Long budget) {
        this.budget = budget;
        this.winningResult = new EnumMap<>(WinningType.class);
        for (WinningType type : WinningType.values()) {
            winningResult.put(type, 0);
        }
    }

    public boolean buyLotto() {
        if (budget >= 1000) {
            budget -= 1000;
            return true;
        }
        return false;
    }

    public void addLotto(List<Integer> lottoNumber) {
        lottos.add(new Lotto(lottoNumber));
    }

    public int getLottosLength() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<WinningType, Integer> getWinningResult() {
        return winningResult;
    }

    public void addWinningResult(WinningType winningType) {
        winningResult.put(winningType, winningResult.get(winningType) + 1);
        reward += winningType.getWinningPrice();
    }

    public double getReturnRate() {
        return this.reward / (this.lottos.size() * 1000);
    }
}
