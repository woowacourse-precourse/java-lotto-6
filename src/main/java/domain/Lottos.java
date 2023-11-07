package domain;

import java.util.ArrayList;
import java.util.List;
import service.MakeObjectService;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Amount amount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < amount.getAmount(); i++) {
            lottos.add(MakeObjectService.lotto());
        }
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        for (Lotto lotto : lottos) {
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

    public List<Boolean> equalBonusNumber(BonusNumber bonusNumber) {
        List<Boolean> isEqual = new ArrayList<>();
        for (Lotto lotto : this.lottos) {
            isEqual.add(bonusNumber.isEqualBonusNumber(lotto));
        }
        return isEqual;
    }
}
