package lotto.model.judge;

import lotto.model.Lotto;
import java.util.List;

public class BonusNumberJudge implements LottoJudge {

    private final int bonusNumber;

    private BonusNumberJudge(final int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumberJudge from(final String bonusNumberInput) {
        int bonusNumber = convertToNumber(bonusNumberInput);
        return new BonusNumberJudge(bonusNumber);
    }

    private static int convertToNumber(final String numberInput) {
        try {
            return Integer.parseInt(numberInput);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public List<Lotto> collectLottoWithMatchSize(final List<Lotto> lottos, final int matchSize) {
        return lottos.stream()
                .filter(lotto -> lotto.isContainsNumber(bonusNumber))
                .toList();
    }
}
