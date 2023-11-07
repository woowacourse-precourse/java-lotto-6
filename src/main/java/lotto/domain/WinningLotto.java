package lotto.domain;

import lotto.type.Prize;

import java.util.HashSet;
import java.util.List;

import static lotto.domain.Lotto.isInRange;
import static lotto.impl.RandomNumberImpl.END_NUM;
import static lotto.impl.RandomNumberImpl.START_NUM;


public class WinningLotto {
    public static final int BONUS_NUMBER_INDEX = 5;
    public static final int SECOND_MATCHING_CORRECT_NUM = 5;
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumbers, int bonusNumber) {
        if(winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력 할 수 없습니다.");
        }
        if(isInRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 1~45 까지의 수를 입력해주세요");
        }
    }




    public Prize matchLotto(Lotto inputLotto) {
        int winningResult = getMatchingCount(inputLotto.getNumbers());

        if(winningResult == SECOND_MATCHING_CORRECT_NUM) {
            return Prize.valueOf(winningResult, isMatchBonusNumber(inputLotto.getNumbers()));
        }
        return Prize.valueOf(winningResult, false);
    }

    private int getMatchingCount(List<Integer> inputNumbers) {
        return winningNumbers.getNumbers().stream()
                .filter(inputNumbers::contains)
                .toList()
                .size();
    }

    private boolean isMatchBonusNumber(List<Integer> inputLotto) {
        return inputLotto.contains(bonusNumber);
    }
}
