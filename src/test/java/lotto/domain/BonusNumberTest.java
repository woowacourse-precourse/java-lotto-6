package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.ExceptionMessage;
import lotto.util.enumerator.LottoRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberTest {
    @DisplayName("입력한 보너스 번호의 값이 45 초과이면 예외가 발생한다.")
    @Test
    void inputBonusNumberByOverValue() {
        assertThatThrownBy(() -> new BonusNumber(77))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_MAX_RANGE.getMessage());
    }

    @DisplayName("입력한 보너스 번호의 값이 1 미만이면 예외가 발생한다.")
    @Test
    void inputBonusNumberByUnderValue() {
        assertThatThrownBy(() -> new BonusNumber(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_LOTTO_NUMBER_MIN_RANGE.getMessage());
    }

    @DisplayName("로또 1개의 번호와 보너스 번호를 비교하고, 일치하면 2등이라는 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateAccordNumbers")
    void accordWithLottoNumber(List<Integer> lottoNumbers, int bonusNumber) {
        // given
        Lotto lotto = new Lotto(lottoNumbers);
        BonusNumber bonus = new BonusNumber(bonusNumber);

        // when
        LottoRank compareResult = bonus.compareWithLottoNumber(lotto);

        // then
        Assertions.assertEquals(LottoRank.SECOND, compareResult);
    }

    @DisplayName("로또 1개의 번호와 보너스 번호를 비교하고, 불일치하면 3등이라는 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("generateDiscordNumbers")
    void discordWithLottoNumber(List<Integer> lottoNumbers, int bonusNumber) {
        // given
        Lotto lotto = new Lotto(lottoNumbers);
        BonusNumber bonus = new BonusNumber(bonusNumber);

        // when
        LottoRank compareResult = bonus.compareWithLottoNumber(lotto);

        // then
        Assertions.assertEquals(LottoRank.THIRD, compareResult);

    }

    static Stream<Arguments> generateAccordNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9, 45), 7),
                Arguments.of(Arrays.asList(2, 4, 6, 8, 10, 12), 6)
        );
    }

    static Stream<Arguments> generateDiscordNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 3, 5, 7, 9, 45), 2),
                Arguments.of(Arrays.asList(2, 4, 6, 8, 10, 12), 5)
        );
    }
}