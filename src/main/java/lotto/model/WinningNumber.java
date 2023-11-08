package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningNumber {
    private final int bonusNumber;
    private final Lotto winningNumbers;

    public WinningNumber(int bonusNumber, Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
        validateDuplicatedBonusNumber(bonusNumber);
        validateNegativeBonusNumber(bonusNumber);
        validateOutRangeBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getStatistics(List<Lotto> lottos) {
        Map<Rank, Integer> resultStatistics = new EnumMap<>(Rank.class);
        resultStatistics.put(Rank.FIRST, 0);
        resultStatistics.put(Rank.SECOND, 0);
        resultStatistics.put(Rank.THIRD, 0);
        resultStatistics.put(Rank.FOURTH, 0);
        resultStatistics.put(Rank.FIFTH, 0);
        resultStatistics.put(Rank.NONE, 0);

        for (Lotto lotto : lottos) {
            Rank rank = getRank(lotto);
            resultStatistics.put(rank, resultStatistics.getOrDefault(rank, 0) + 1);
        }
        return resultStatistics;
    }

    private Rank getRank(Lotto lotto) {
        int correctNum = compareLotto(lotto);
        boolean isBonus = false;

        if (correctNum == 5) {
            isBonus = lotto.contains(bonusNumber);
        }
        return Rank.findWhichRank(correctNum, isBonus);
    }

    private int compareLotto(Lotto lotto) {
        return (int) lotto.toList()
                .stream()
                .filter(winningNumbers::contains)
                .count();
    }


    private void validateNegativeBonusNumber(int bonusNumber) {
        if (bonusNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 음수가 될 수 없습니다.");
        }
    }

    private void validateOutRangeBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 범위는 1부터 45 사이입니다.");
        }
    }

    private void validateDuplicatedBonusNumber(int bonusNumber) {
        if (winningNumbers.toList().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 보너스 번호와 중복되는 숫자가 있습니다.");
        }
    }
}
