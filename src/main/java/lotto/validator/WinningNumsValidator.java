package lotto.validator;

import lotto.GameDetail;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 당첨 번호를 검증하는 클래스
 */
public class WinningNumsValidator {

    public boolean isValid(String winningNums) {
        if (winningNums == null || winningNums.isBlank()) {
            throw new IllegalArgumentException("빈 당첨 번호 입력값");
        }
        String[] splitedNums = winningNums.split(GameDetail.WINNING_NUM_SEPARATOR);
        List<Integer> winningNumsToInt = Arrays.stream(splitedNums).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
        return isValid(winningNumsToInt);
    }

    public boolean isValid(List<Integer> winningNums) {
        if (winningNums.size() == 0) {
            throw new IllegalArgumentException("빈 당첨 번호 입력값");
        }

        if (winningNums.size() != GameDetail.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("%d개가 아닌 당첨 번호 입력값", GameDetail.LOTTO_NUMBER_COUNT));
        }

        if (!isAllPositiveNumber(winningNums)) {
            throw new IllegalArgumentException("양의 정수가 아닌 값이 포함된 당첨 번호 입력값");
        }

        if (isDuplicateNumber(winningNums)) {
            throw new IllegalArgumentException("중복값이 포함된 당첨 번호 입력값");
        }
        return true;
    }

    private boolean isAllPositiveNumber(List<Integer> nums) {
        return nums.stream().allMatch(num -> num > 0);
    }

    private boolean isDuplicateNumber(List<Integer> nums) {
        return nums.stream().distinct().count() != GameDetail.LOTTO_NUMBER_COUNT;
    }

}
