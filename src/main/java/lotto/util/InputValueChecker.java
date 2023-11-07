package lotto.util;

import lotto.exception.NotValidInputException;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.exception.GameExceptionMessage.*;
import static lotto.util.GameConstant.*;

public class InputValueChecker {
    private final String REGEXP_NUMBER_PATTERN = "\\d{1,}"; // 숫자만 입력 가능하다.
    private final String REGEXP_COST_PATTERN = "^.*0{3,}$"; // 1000 단위의 수만 입력 가능하다.

    // 사용자 로또 구매 금액의 유효성을 판단한다.
    public void checkCostValidation(String cost) throws NotValidInputException {
        checkNumberValidation(cost);
        checkFormatValidation(cost);
    }

    // 사용자가 입력하는 당첨 번호의 유효성을 판단한다.
    public void checkWinnerNumberValidation(List<String> winnerNumber) throws NotValidInputException {
        checkLengthValidation(winnerNumber);
        checkDupValidation(winnerNumber);
        for(String number : winnerNumber) {
            checkLottoNumberValidation(number);
        }
    }

    // 사용자가 입력하는 보너스 번호의 유효성을 판단한다.
    public void checkBonusNumberValidation(String bonusNumber, List<Integer> winnerNumber) throws NotValidInputException {
        checkContainValidation(bonusNumber, winnerNumber);
    }

    // 사용자가 입력하는 보너스 번호의 유효성을 판단한다.
    public void checkLottoNumberValidation(String bonusNumber) throws NotValidInputException {
        checkNumberValidation(bonusNumber);
        checkRangeValidation(bonusNumber);
    }

    // 사용자로부터 입력 받은 값이 숫자가 아닐 경우, 오류를 반환한다.
    private void checkNumberValidation(String inputValue) {
        if(!Pattern.matches(REGEXP_NUMBER_PATTERN, inputValue)) {
            throw new NotValidInputException(INPUT_VALUE_IS_NOT_NUMBER.getMessage());
        }
    }

    // 사용자로부터 입력 받은 값이 1000 단위가 아닐 경우, 오류를 반환한다.
    private void checkFormatValidation(String inputValue) {
        if(!Pattern.matches(REGEXP_COST_PATTERN, inputValue)) {
            throw new NotValidInputException(INPUT_VALUE_NOT_VALID_FORMAT.getMessage());
        }
    }

    // 사용자가 입력한 당첨 번호의 길이가 유효하지 않을 경우, 오류를 반환한다.
    private void checkLengthValidation(List<String> inputValue) {
        if(inputValue.size() != CONSTANT_LOTTO_LENGTH.getConstant())
            throw new NotValidInputException(INPUT_VALUE_NOT_VALID_LENGTH.getMessage());
    }

    // 사용자가 입력한 당첨 번호에 중복되는 수가 존재하는 경우 오류를 반환한다.
    private void checkDupValidation(List<String> inputValue) {
        long distinctValue = inputValue.stream().distinct().count();

        if(inputValue.size() != distinctValue) {
            throw new NotValidInputException(INPUT_VALUE_MUST_DISTINCT.getMessage());
        }
    }

    // 사용자가 입력한 보너스 번호가 당첨 번호에 포함된 경우, 오류를 반환한다.
    private void checkContainValidation(String bonusNumber, List<Integer> winnerNumber) {
        int parsedBonusNumber = Integer.parseInt(bonusNumber);

        if(winnerNumber.contains(parsedBonusNumber)) {
            throw new NotValidInputException(INPUT_VALUE_MUST_DISTINCT.getMessage());
        }
    }

    // 사용자로부터 입력 받은 값이 유효한 로또 번호가 아닐 경우, 오류를 반환한다.
    private void checkRangeValidation(String inputValue) {
        int lottoValue = Integer.parseInt(inputValue);

        if(lottoValue < CONSTANT_LOTTO_MIN_NUMBER.getConstant() || lottoValue > CONSTANT_LOTTO_MAX_NUMBER.getConstant())
            throw new NotValidInputException(INPUT_VALUE_NOT_VALID_RANGE.getMessage());
    }
}
