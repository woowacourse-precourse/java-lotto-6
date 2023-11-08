package lotto;

import java.util.List;

public class LottoWinningNumber {

    private List<Integer> winningNumbers;


    public LottoWinningNumber(List<Integer> winningNumbers) {
        validate(winningNumbers);
        validateNumberRange(winningNumbers);
        validateNumbersDuplicates(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6개 입니다.");
        }
    }

    private void validateNumberRange(List<Integer> winningNumbers) {
        for (int i = 0; i < winningNumbers.size(); i++) {
            if (winningNumbers.get(i) < 1 || winningNumbers.get(i) > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1이상 45이하의 숫자로 이루어져야 합니다.");
            }
        }
    }

    private static boolean checkNumbersDuplicates(List<Integer> inputNumbers) {
        for (int i = 0; i < inputNumbers.size() - 1; i++) {
            for (int j = i + 1; j < inputNumbers.size(); j++) {
                if (inputNumbers.get(i).equals(inputNumbers.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void validateNumbersDuplicates(List<Integer> inputNumbers) {
        if (checkNumbersDuplicates(inputNumbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다. 다시 입력해 주세요.");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }


}
