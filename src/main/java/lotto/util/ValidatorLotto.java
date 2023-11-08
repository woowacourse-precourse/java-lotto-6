package lotto.util;

import lotto.domain.EnumLotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class ValidatorLotto {
    public static void validateWinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateUniqueBonusNumber(winningNumbers, bonusNumber);
    }

    public static void validateLottoNumbers(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateNumbersRange(numbers);
        validateUniqueNumber(numbers);
    }

    private static void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != EnumLotto.LOTTO_LENGTH.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 총 6개입니다.");
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        for(int number : numbers){
            validateNumberRange(number);
        }
    }

    private static void validateNumberRange(int number) {
        if (number < EnumLotto.START_NUMBER.getNumber() || number > EnumLotto.END_NUMBER.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validateUniqueNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if(uniqueNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void validateUniqueBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}