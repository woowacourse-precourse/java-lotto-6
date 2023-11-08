package lotto.utils;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoGameConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    public void validateMoney(String input) {
        validateEmpty(input);
        validateNumber(input);
        int money = parseInteger(input);
        validateNumberRange(money);
        validateMoneyUnit(money);
    }

    public void validateLottoWinningNumber(String lottoNumbers) {
        validateEmpty(lottoNumbers);
        String[] lottoNumber = splitNumbers(lottoNumbers);
        validateLottoSize(lottoNumber);
        validateDetailNumbers(lottoNumber);
        validateDuplicateNumbers(lottoNumber);
    }

    public void validateLottoWinningBonusNumber(String bonusNumber, List<Integer> lottoWinningNumbers) {
        validateEmpty(bonusNumber);
        int bonus = parseInteger(bonusNumber);
        validateNumberRange(bonus);
        validateDuplicateNumber(lottoWinningNumbers, bonus);
    }

    private void validateEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_INPUT_ERROR.getMessage());
        }
    }

    private void validateNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_ERROR.getMessage());
            }
        }
    }

    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void validateNumberRange(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void validateMoneyUnit(int money) {
        if (money % LottoGameConfig.LOTTO_TICKET_PRICE_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_UNIT_ERROR.getMessage());
        }
    }

    private String[] splitNumbers(String lottoNumbers) {
        return lottoNumbers.replace(" ", "").split(",");
    }

    private void validateLottoSize(String[] lottoNumber) {
        if (lottoNumber.length != LottoGameConfig.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateDetailNumbers(String[] lottoNumber) {
        for (String number : lottoNumber) {
            int parsedNumber = parseInteger(number);
            validateNumberRange(parsedNumber);
        }
    }

    private void validateDuplicateNumbers(String[] lottoNumber) {
        Set<String> numberSet = new HashSet<>(List.of(lottoNumber));
        if (numberSet.size() != LottoGameConfig.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }

    private void validateDuplicateNumber(List<Integer> lottoWinningNumbers, int bonusNumber) {
        if (lottoWinningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getMessage());
        }
    }
}
