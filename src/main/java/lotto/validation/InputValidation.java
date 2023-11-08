package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoInformation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {

    public void validationMoney(String input) {
        isEmptyValidation(input);
        isNumberValidation(input);
        changeInteger(input);
        isNumberRangeValidation(input);
        isMoneyUnitValidation(input);
    }

    public void validationLottoWinningNumber(String lottoNumbers) {
        isEmptyValidation(lottoNumbers);
        validationSplitNumbers(lottoNumbers);
    }

    private void validationSplitNumbers(String lottoNumbers) {
        String[] lottoNumber = lottoNumbers.replace(" ", "").split(",");
        isLottoSize(lottoNumber);
        validationDetailNumbers(lottoNumber);
        isDuplicateNumber(lottoNumber);
    }

    private void validationDetailNumbers(String[] lottoNumber) {
        for (int i = 0; i < LottoInformation.LOTTO_NUMBER_TOTAL_SIZE.getNumber(); i++) {
            changeInteger(lottoNumber[i]);
            checkNumberRange(lottoNumber[i]);
        }
    }

    public void validationLottoWinningBonusNumber(String bonusNumber, List<Integer> lottoWinningNumbers) {
        isEmptyValidation(bonusNumber);
        changeInteger(bonusNumber);
        checkNumberRange(bonusNumber);
        checkWinningNumbersDuplication(lottoWinningNumbers, bonusNumber);
    }

    private void isEmptyValidation(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NULL_MESSAGE.getMessage());
        }
    }

    private void isNumberValidation(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER_MESSAGE.getMessage());
            }
        }
    }

    private void changeInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_EXPRESS_NUMBER_RANGE_MESSAGE.getMessage());
        }
    }

    private void isNumberRangeValidation(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER_Range_MESSAGE.getMessage());
        }
    }

    private void isMoneyUnitValidation(String input) {
        if (Integer.parseInt(input) % LottoInformation.MONEY_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_MONEY_UNIT_MESSAGE.getMessage());
        }
    }

    private void isLottoSize(String[] lottoNumber) {
        if (lottoNumber.length != LottoInformation.LOTTO_NUMBER_TOTAL_SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_LOTTO_SIZE_MESSAGE.getMessage());
        }
    }

    private void checkNumberRange(String s) {
        if (Integer.parseInt(s) < LottoInformation.MIN_LOTTO_NUMBER.getNumber() ||
                Integer.parseInt(s) > LottoInformation.MAX_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_LOTTO_RANGE_MESSAGE.getMessage());
        }
    }

    private void isDuplicateNumber(String[] lottoNumber) {
        Set<String> checkDuplicationNumber = new HashSet<>(List.of(lottoNumber));
        if (checkDuplicationNumber.size() != LottoInformation.LOTTO_NUMBER_TOTAL_SIZE.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATION_LOTTO_NUMBER_MESSAGE.getMessage());
        }
    }

    private void checkWinningNumbersDuplication(List<Integer> lottoWinningNumbers, String bonusNumber) {
        if (lottoWinningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATION_LOTTO_NUMBER_MESSAGE.getMessage());
        }
    }
}
