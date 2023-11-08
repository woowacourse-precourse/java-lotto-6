package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.constants.LottoValues;
import lotto.constants.WinningType;

public class WinningCalculator {
    private Integer totalReturn = LottoValues.ZERO.getValue();
    private Map<WinningType, Integer> totalCounts = new HashMap<>();

    public WinningCalculator() {
        for (WinningType type : WinningType.values()) {
            totalCounts.put(type, LottoValues.ZERO.getValue());
        }
    }

    public Integer getCount(WinningType type) {
        return totalCounts.get(type);
    }

    public void caculate(Lottos lottos, Winning winning) {
        for (Lotto lotto : lottos.getLottos()) {
            Integer lottoMachCount = countMatchingLotto(lotto, winning);
            Integer bonusMatchCount = countMatchingBonusNumber(lotto, winning.getBonusNumber());

            setTotalCount(lottoMachCount, bonusMatchCount);
        }
    }

    private Integer countMatchingLotto(Lotto lotto, Winning winning) {
        Integer count = LottoValues.ZERO.getValue();

        for (Integer winningNumber : winning.getNumbers()) {
            count += (int) lotto.getNumbers().stream().filter(e -> e == winningNumber).count();
        }

        return count;
    }

    private Integer countMatchingBonusNumber(Lotto lotto, Integer bonusNumber) {
        return (int) lotto.getNumbers().stream().filter(e -> e == bonusNumber).count();
    }

    private void setTotalCount(Integer lottoMachCount, Integer bonusMatchCount) {
        for (WinningType type : WinningType.values()) {
            if (type.getCount().equals(lottoMachCount) && type.getBonusCount().equals(bonusMatchCount)) {
                totalCounts.merge(type, LottoValues.ONE.getValue(), Integer::sum);
                totalReturn += type.getAmount();
            }
        }
    }

    public Double calculateProfitMargin(Integer lottoAmount) {
        return ((totalReturn * 100) / (double) lottoAmount);
    }
}
