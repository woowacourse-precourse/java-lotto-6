package lotto.common;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @DisplayName("타겟이 단위로 나누어 떨어지면 true 를 반환한다.")
    @Test
    void 단위_나누기_검증_테스트() {
        int unit = 1000;
        int validTarget = 8000;
        int inValidTarget = 8200;

        boolean trueResult = Validator.isMultipleOfNumber(validTarget, unit);
        boolean falseResult = Validator.isMultipleOfNumber(inValidTarget, unit);

        assertThat(trueResult).isTrue();
        assertThat(falseResult).isFalse();
    }

    @DisplayName("타겟 리스트의 모든 값중 중복된 값이 있으면 true 를 반환한다.")
    @Test
    void 중복_검증_테스트() {
        List<Integer> duplicateTargetList = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> nonDuplicateTargetList = List.of(1, 2, 3, 4, 5, 6);

        boolean trueResult = Validator.isDuplicateValue(duplicateTargetList);
        boolean falseResult = Validator.isDuplicateValue(nonDuplicateTargetList);

        assertThat(trueResult).isTrue();
        assertThat(falseResult).isFalse();
    }

    @DisplayName("타겟 리스트의 모든 값이 기준 범위에 속하면 true 를 반환한다.")
    @Test
    void 리스트_숫자_범위_검증_테스트() {
        List<Integer> validTarget = List.of(1, 2, 3, 4, 5, 5);
        List<Integer> inValidTarget = List.of(1, 2, 3, 4, 5, 46);
        int min = 1;
        int max = 45;

        boolean trueResult = Validator.isBetweenValue(validTarget, min, max);
        boolean falseResult = Validator.isBetweenValue(inValidTarget, min, max);

        assertThat(trueResult).isTrue();
        assertThat(falseResult).isFalse();
    }

    @DisplayName("타겟 리스트의 값의 개수가 기준 개수와 같으면 true 를 반환한다.")
    @Test
    void 리스트_크기_검증_테스트() {
        List<Integer> validTarget = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> inValidTarget = List.of(1, 2, 3, 4, 5, 6,7);
        int count = 6;

        boolean trueResult = Validator.isListSizeEquals(validTarget, count);
        boolean falseResult = Validator.isListSizeEquals(inValidTarget, count);

        assertThat(trueResult).isTrue();
        assertThat(falseResult).isFalse();
    }

}