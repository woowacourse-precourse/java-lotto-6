package lotto.utils;

import static lotto.utils.CalculationUtils.hasDuplicates;
import static lotto.utils.CalculationUtils.isNumberInRange;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CalculationUtilsTest {

    @Test
    @DisplayName("기능30 테스트 : isNumberInRange는 타겟 숫자가 원하는 범위 내에 있으면 true를 반환한다.")
    void isNumberInRangeShouldRetrunTrueWhenTargetInGoalRange() {
        // given
        int[] targetArr = new int[]{1, 23, 45};

        int start = 1;
        int end = 45;

        boolean result = false;

        // when, then
        for (int target : targetArr) {
            result = isNumberInRange(target, start, end);
            assertThat(result).isEqualTo(true);
        }
    }

    @Test
    @DisplayName("기능30 테스트 : isNumberInRange는 타겟 숫자가 원하는 범위 내에 있지 않으면 false를 반환한다.")
    void isNumberInRangeShouldRetrunFalseWhenTargetNotInGoalRange() {
        // given
        int[] targetArr = new int[]{0, 46};

        int start = 1;
        int end = 45;

        boolean result = false;

        // when, then
        for (int target : targetArr) {
            result = isNumberInRange(target, start, end);
            assertThat(result).isEqualTo(false);
        }
    }

    @Test
    @DisplayName("기능31 테스트 : 리스트에 중복값이 없으면 hasDuplicates는 false를 반환한다.")
    void hasDuplicatesShouldReturnFalseWhenListDoesNotHaveDuplicates() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);

        // when
        boolean result = hasDuplicates(list);

        // then
        assertThat(result).isEqualTo(false);
    }

    @Test
    @DisplayName("기능31 테스트 : 리스트에 중복값이 있으면 hasDuplicates는 true를 반환한다.")
    void hasDuplicatesShouldReturnFalseWhenListHaveDuplicates() {
        // given
        List<Integer> list = List.of(1, 1, 3, 4, 5, 6);

        // when
        boolean result = hasDuplicates(list);

        // then
        assertThat(result).isEqualTo(true);
    }

}