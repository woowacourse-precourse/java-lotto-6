package lotto.model;

import lotto.Utils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.Exception;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto (String numbers) {
        List<Integer> winningNumbers = convertToNumeric(numbers);
        validate(winningNumbers);
        this.numbers = winningNumbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private List<Integer> convertToNumeric(String numbersInput) {
        numbersInput = deleteWhiteSpace(numbersInput);
        numbersInput = correctCommas(numbersInput);
        validateWinningNumberNumeric(numbersInput);
        return Utils.convertStringToIntegerList(numbersInput);
    }

    private void validate(List<Integer> numbers) {
        validateWinningNumberLength(numbers);
        validateWinningNumberRange(numbers);
        validateWinningNumberDuplication(numbers);
    }

    void validateWinningNumberLength(List<Integer> winningNumber) {
        if (LottoUtils.isInvalidLottoSize(winningNumber.size())) {
            Exception.raiseInvalidWinningNumberSizeException();
        }
    }

    private String deleteWhiteSpace(String winningNumber) {
        return winningNumber.replace("\\s", "");
    }

    private String correctCommas(String winningNumber) {
        winningNumber = winningNumber.replaceAll("^,|,$", "");
        winningNumber = winningNumber.replaceAll(",+", ",");
        return winningNumber;
    }

    private boolean isInvalidInputArguments(Character argument) {
        return !(Character.isDigit(argument) || argument == ',');
    }
    private void validateWinningNumberNumeric(String winningNumber) {
        for (int winningNumberIndex = 0; winningNumberIndex < winningNumber.length(); winningNumberIndex++) {
            if (isInvalidInputArguments(winningNumber.charAt(winningNumberIndex))) {
                Exception.raiseInvalidWinningNumberArgumentException();
            }
        }
    }

    private void validateWinningNumberRange(List<Integer> winningNumber) {
        for (int lottoNumber : winningNumber) {
            if (LottoUtils.isOutOfLottoRange(lottoNumber)) {
                Exception.raiseInvalidWinningNumberRangeException();
            }
        }
    }

    private void validateWinningNumberDuplication(List<Integer> winningNumber) {
        Set<Integer> comparativeGroup = new HashSet<>(winningNumber);
        if (comparativeGroup.size() != winningNumber.size()) {
            Exception.raiseInvalidWinningNumberDuplicationException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

