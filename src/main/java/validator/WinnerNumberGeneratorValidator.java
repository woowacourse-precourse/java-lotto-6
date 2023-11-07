package validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinnerNumberGeneratorValidator {
    public void vaildWinnerNumbers(List<Integer> winnerNumbers) {
        vaildWinnerNumberRange(winnerNumbers);
        vaildWinnerNumberSize(winnerNumbers);
        vaildWinnerNumberDuplication(winnerNumbers);
    }

    void vaildWinnerNumberRange(List<Integer> winnerNumbers) {
        for (int winnerNumber : winnerNumbers) {
            if (winnerNumber < 1) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호 생성 시 최소값(1) 보다 작은 값이 있습니다.");
            }
            if (winnerNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호 생성 시 최대값(45) 보다 큰 값이 있습니다.");
            }
        }
    }

    void vaildWinnerNumberSize(List<Integer> randomNumbers) {
        if (randomNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개로 생성되지 않았습니다.");
        }
    }

    void vaildWinnerNumberDuplication(List<Integer> randomNumbers) {
        Set<Integer> uniqueNumber = new HashSet<>(randomNumbers);
        if (uniqueNumber.size() != randomNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 중 중복된 값이 있습니다.");
        }
    }
}
