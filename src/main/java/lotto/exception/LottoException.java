package lotto.exception;

import lotto.Constants;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoException {

    public void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumbersLength(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumbersPermittedRange(numbers);
    }

    public void validateBonusNumber(List<Integer> inputNumbers, int inputBonusNumber) {
        validateBonusNumberPermittedRange(inputBonusNumber);
        validateDuplicatedBonusNumber(inputNumbers, inputBonusNumber);
    }

    // lotto numbers
    public void validInputLottoNumbers(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            char n = numbers.charAt(i);
            if (!(Character.isDigit(n)) || n == ',') {
                throw new IllegalArgumentException(Constants.ERROR + "로또 번호 입력은 숫자와 콤마(,)로 구성되어야 합니다");
            }
        }
    }
    public void validateLottoNumbersLength(List<Integer> numbers) {
        if (numbers.size() != Constants.DESIGNATED_LOTTO_LENGTH) {
            throw new IllegalArgumentException(Constants.ERROR + "로또 번호는 6개이어야 합니다");
        }
    }
    public void validateNumbersPermittedRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > Constants.MAX_RANGE_NUMBER || number < Constants.MIN_RANGE_NUMBER) {
                throw new IllegalArgumentException(Constants.ERROR + "로또 번호의 범위는 1~45 사이여야 합니다");
            }
        }
    }
    public void validateDuplicatedNumbers(List<Integer> inputNumbers) {
        Set<Integer> numbers = new HashSet<>();
        inputNumbers.stream().map(numbers::add).collect(Collectors.toList());
        if (numbers.size() != Constants.DESIGNATED_LOTTO_LENGTH) {
            throw new IllegalArgumentException(Constants.ERROR + "번호가 중복 되었습니다");
        }
    }

    // bonus number
    public void validInputBonusNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char n = number.charAt(i);
            if (!Character.isDigit(n)) {
                throw new IllegalArgumentException(Constants.ERROR + "보너스 번호는 숫자로 구성되어야 합니다");
            }
        }
    }
    public void validateBonusNumberPermittedRange(int bonusNumber) {
        if (bonusNumber > Constants.MAX_RANGE_NUMBER || bonusNumber < Constants.MIN_RANGE_NUMBER) {
            throw new IllegalArgumentException(Constants.ERROR + "보너스 번호의 범위는 1~45이여야 합니다");
        }
    }
    public void validateDuplicatedBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Constants.ERROR + "보너스 번호가 중복 되었습니다");
        }
    }
}
