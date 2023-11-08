package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoDraw {
    private List<Lotto> lottos = new ArrayList();

    private List<Integer> drawNumbers;
    private Integer bonusNumber;

    public void createLottos(Integer amount, Integer price) {
        for (int i = 0; i < amount / price; i++) {
            lottos.add(Lotto.create());
        }
    }

    public List<Rank> getRanks() {
        return lottos.stream()
                .map(lotto -> lotto.calculateRank(drawNumbers, bonusNumber))
                .toList();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setDrawNumbers(List<Integer> drawNumbers) {
        this.drawNumbers = drawNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
