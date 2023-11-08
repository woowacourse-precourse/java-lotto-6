package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidationTest {
    static Stream<Arguments> countNotSixGenerateList() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5)),
                Arguments.of(Arrays.asList(1,2,3,4,5,6,7))
        );
    }

    @DisplayName("입력값이 1미만 45초과이면 예외가 발생한다.")
    @ParameterizedTest()
    @ValueSource(ints = {-1,46})
    void isPermitRange(int number) {
        assertThatThrownBy(() -> LottoValidation.isPermitRange(number,"로또"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 번호가 6개 미만이거나 초과하면 예외가 발생한다.")
    @ParameterizedTest()
    @MethodSource("countNotSixGenerateList")
    void lottoCountIsSix(List<Integer> lotto) {
        assertThatThrownBy(() -> LottoValidation.lottoCountIsSix(lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개를 입력해야 합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복이 있으면 예외가 발생한다.")
    void duplicateLottoNumber() {
        assertThatThrownBy(() -> LottoValidation.duplicateLottoNumber(List.of(1,1,2,3,4,5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }

    @Test
    @DisplayName("로또 번호에 포함되어 있는 숫자를 보너스 번호로 입력하면 예외가 발생한다.")
    void duplicationLottoAndBonusNumber() {
        assertThatThrownBy(() -> LottoValidation.duplicationLottoAndBonusNumber(List.of(1,2,3,4,5,6),"6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 번호가 있습니다.");
    }
}