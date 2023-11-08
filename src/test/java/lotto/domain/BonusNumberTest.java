package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BonusNumberTest {

    List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @ValueSource(strings = {"one", "ten"})
    @DisplayName("보너스 숫자는 문자나 문자열이면 안된다.")
    void bounusNumberIsDigit(String inputBonusNumber) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lottoNumbers))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("보너스 숫자는 아라비아 숫자이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "46", "66"})
    @DisplayName("보너스 숫자는 1과 45사이의 값이다.")
    void bonusNumberRange(String inputBonusNumber) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 숫자는 1과 45사이 이어야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("generateDuplicateBonusNumber")
    @DisplayName("보너스 숫자가 당첨번호와 중복되면 예외 발생")
    void bonusNumberDuplicateWithExistLottoNumber(String inputBonusNumber, List<Integer> exisLottoNumbers) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, exisLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 숫자는 이전 당첨 번호와 중복되면 안됩니다.");
    }

    static Stream<Arguments> generateDuplicateBonusNumber() {
        return Stream.of(
                Arguments.of("11", Arrays.asList(2, 3, 4, 11, 12, 13))
        );
    }

}
