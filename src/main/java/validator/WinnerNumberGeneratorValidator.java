package validator;

import java.util.List;

public class WinnerNumberGeneratorValidator {
    void vaildRandomNumberRange(List<Integer> winnerNumbers) {
        for (int winnerNumber : winnerNumbers) {
            if (winnerNumber < 1) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호 생성 시 최소값(1) 보다 작은 값이 있습니다.");
            }
            if (winnerNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호 생성 시 최대값(45) 보다 큰 값이 있습니다.");
            }
        }
    }
}
