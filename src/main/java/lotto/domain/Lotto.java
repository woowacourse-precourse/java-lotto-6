package lotto.domain;

import static lotto.message.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static lotto.message.ErrorMessage.SAME_NUMBER_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.message.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.getMessage());
        }
        if (hasSameNumber(numbers)) {
            throw new IllegalArgumentException(SAME_NUMBER_ERROR.getMessage());
        }
    }

    public StringBuilder getLottoNumbersString(String open, String close, String connections) {
        StringBuilder lottoNumbers = new StringBuilder();
        lottoNumbers.append(open);
        for(int i = 0; i < numbers.size(); i++) {
            int lottoNumber = numbers.get(i);
            if(i == numbers.size() - 1) {
                lottoNumbers.append(lottoNumber);
                break;
            }
            lottoNumbers.append(lottoNumber + connections);
        }
        lottoNumbers.append(close);

        return lottoNumbers;
    }
    public int checkWinning(int[] winningNumbers, int bonusNumber) {
        int winningCount = 0;
        for (int i = 0; i < winningNumbers.length; i++) {
            if(numbers.contains(winningNumbers[i])) {
                winningCount++;
            }
        }

        if(winningCount == 5 && numbers.contains(bonusNumber)) {
            return 9;
        }
        return winningCount;
    }

    private boolean hasSameNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(int num : numbers) {
            if (!uniqueNumbers.add(num)) {
                return true;
            }
        }
        return false;
    }

}
