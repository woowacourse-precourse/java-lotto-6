package lotto.validator;

import lotto.GameDetail;

/**
 * 보너스 번호를 검증하는 클래스
 */
public class BonusNumValidator {

    public boolean isValid(String nums) {
        if (nums == null || nums.isBlank()) {
            throw new IllegalArgumentException("빈 보너스 번호 입력값");
        }
        return isValid(Integer.parseInt(nums));
    }

    public boolean isValid(Integer nums) {
        if (nums == null) {
            throw new IllegalArgumentException("빈 보너스 번호 입력값");
        }

        if (nums <= 0) {
            throw new IllegalArgumentException("양의 정수가 아닌 값이 포함된 당첨 번호 입력값");
        }

        if (nums < GameDetail.LOTTO_NUMBER_MIN || nums > GameDetail.LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(String.format("%d ~ %d 사이의 값이 아닌 보너스 번호 입력값", GameDetail.LOTTO_NUMBER_MIN, GameDetail.LOTTO_NUMBER_MAX));
        }

        return true;
    }

}
