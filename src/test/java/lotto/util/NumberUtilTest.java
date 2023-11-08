package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


class NumberUtilTest {

    @Test
    @DisplayName("랜덤 숫자 생성 성공 케이스")
    void 랜덤_숫자_생성_성공_테스트() {
        List<Integer> numbers = NumberUtil.numberGenerator(1, 45, 6);
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 범위 검증 성공 케이스")
    void 숫자_범위_검증_성공_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 6, 3, 22, 5);
        assertThatCode(() -> NumberUtil.validateNumberRange(1, 45, numbers))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("숫자 범위 검증 실패 케이스")
    void 숫자_범위_검증_실패_테스트() {
        List<Integer> numbers = Arrays.asList(1, 2, 6, 60, 22, 5);
        assertThatThrownBy(() -> NumberUtil.validateNumberRange(1, 45, numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}