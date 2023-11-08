package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.Error.ErrorType;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static void validate(List<Integer> numbers) {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        boolean duplication = setNumbers.size() != numbers.size();

        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_SIZE.getMessage());
        } else if (duplication) {
            throw new IllegalArgumentException(ErrorType.DUPLICATION.getMessage());
        } else if (!isInRange(numbers)) {
            throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_RANGE.getMessage());
        }
    }

    private static boolean isInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public void validate(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorType.INVALID_LOTTO_RANGE.getMessage());
        } else if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorType.DUPLICATION.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public void inputBonusNumber(int bonusNumber) {
        this.numbers.add(bonusNumber);
    }

    public static List<Integer> parseIntLottoNumber(String[] inputLottoNumbers, List<Integer> lottoNumbers) {
        for (String inputLottoNumber : inputLottoNumbers) {
            lottoNumbers.add(Integer.parseInt(inputLottoNumber));
        }
        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
