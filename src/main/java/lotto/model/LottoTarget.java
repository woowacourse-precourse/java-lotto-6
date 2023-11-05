package lotto.model;

import java.util.List;

public class LottoTarget {
    private final Lotto lottoTarget;
    private final int bonusNumber;

    public LottoTarget(Lotto lottoTarget, int bonusNumber) {
        this.lottoTarget = lottoTarget;
        this.bonusNumber = bonusNumber;
    }

    public ResultStatus grading(Lotto lotto) {
        int count = 0;
        boolean bonusCheck = false;
        List<Integer> lottoNumbers = lotto.getNumbers();

        for (int i = 0; i < 6; i++) {
            if (lottoTarget.contains(lottoNumbers.get(i))) {
                count += 1;
            } else if (lottoNumbers.get(i) == bonusNumber) {
                bonusCheck = true;
            }
        }

        return calculateResult(count, bonusCheck);
    }

    private ResultStatus calculateResult(int count, boolean bonusCheck) {
        if (count == 3) {
            return ResultStatus.THREE;
        } else if (count == 4) {
            return ResultStatus.FOUR;
        } else if (count == 5 && !bonusCheck) {
            return ResultStatus.FIVE;
        } else if (count == 5) {
            return ResultStatus.BONUS;
        } else if (count == 6) {
            return ResultStatus.SIX;
        }

        return ResultStatus.NONE;
    }
}
