package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoConstraintTest {

    @Test
    @DisplayName("사이즈 검증 성공")
    void checkSizeSuccess() {
        assertThat(LottoConstraint.checkSize(6)).isTrue();
    }

    @Test
    @DisplayName("사이즈 검증 실패")
    void checkSizeFail() {
        assertThat(LottoConstraint.checkSize(1)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,45})
    @DisplayName("범위 검증 성공")
    void inRangesSuccess(Integer target) {
        assertThat(LottoConstraint.inRange(target)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0,46,47})
    @DisplayName("범위 검증 실패")
    void inRangeFail(Integer target) {
        assertThat(LottoConstraint.inRange(target)).isFalse();
    }
}
