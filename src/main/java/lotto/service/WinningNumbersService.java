package lotto.service;

import lotto.constants.AppConstants;
import lotto.constants.ErrorConstants;
import lotto.domain.WinningNumbers;
import lotto.utils.ListUtil;
import lotto.utils.StringUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersService {
    public WinningNumbers generateWinningNumbers(String winningNum) {
        validateWinningNumbers(winningNum);
        return new WinningNumbers(winningNum);
    }

    public void setBonusNumber(WinningNumbers winningNumbers, String bunsNum) {
        validateBonusNumber(bunsNum);
        winningNumbers.setBonusNumber(Integer.parseInt(bunsNum));
    }

    private void validateWinningNumbers(String winningNum) {
        // 당첨 번호 유효성 검사
        StringUtil.checkNotNull(winningNum);
        String[] arr = winningNum.split(AppConstants.INPUT_DELIMITER);
        checkArrayLength(arr);
        checkNumeric(arr);

        List<Integer> numList = Arrays.stream(arr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        checkWinningNumRange(numList);
        checkWinningNumDuplicate(numList);
    }

    private void validateBonusNumber(String bunsNum) {
        // 보너스 번호 유효성 검사
        StringUtil.checkNotNull(bunsNum);
        StringUtil.checkNumeric(bunsNum);
        int bonusNum = Integer.parseInt(bunsNum);
        checkRange(bonusNum);
    }

    public void checkNumeric(String[] arr) {
        for (String str : arr) {
            if (!StringUtil.isNumeric(str)) {
                throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMERIC.getData());
            }
        }
    }

    public void checkArrayLength(String[] arr) {
        if (arr.length != AppConstants.LOTTO_LENGTH) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_LENGTH.getData());
        }
    }

    public void checkWinningNumRange(List<Integer> numList) {
        if (!ListUtil.checkRange(numList)) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_RANGE.getData());
        }
    }

    public void checkWinningNumDuplicate(List<Integer> numList) {
        if (!ListUtil.checkDuplicateValue(numList)) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_DUPLICATE.getData());
        }
    }

    public void checkRange(int num) {
        if (num < AppConstants.RANDOM_RANGE_MIN || num > AppConstants.RANDOM_RANGE_MAX) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_BONUS_NUMBER_RANGE.getData());
        }
    }
}