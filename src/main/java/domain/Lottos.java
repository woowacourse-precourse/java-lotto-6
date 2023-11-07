package domain;

import java.util.ArrayList;
import java.util.List;
import service.MakeObjectService;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Amount amount) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < amount.getAmount(); i++) {
            this.lottos.add(MakeObjectService.lotto());
        }
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        for (Lotto lotto : this.lottos) {
            message.append(lotto);
            message.append("\n");
        }

        return message.toString();
    }

    public List<Integer> equalNumbersCount(Lotto winningNumber) {

        List<Integer> equalCount = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            equalCount.add(winningNumber.equalNumbersCount(lotto));
        }
        return equalCount;
    }

    public List<Boolean> isEqualBonusNumber(BonusNumber bonusNumber) {
        List<Boolean> isEqual = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            isEqual.add(bonusNumber.isEqual(lotto));
        }
        return isEqual;
    }
}
