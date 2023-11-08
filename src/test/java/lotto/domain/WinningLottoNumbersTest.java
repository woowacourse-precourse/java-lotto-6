package lotto.domain;

import lotto.domain.dto.input.WinningLottoRequestBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class WinningLottoNumbersTest {
    static Stream<Arguments> provideDuplicatedNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), 12)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDuplicatedNumber")
    @DisplayName("당첨 번호와 보너스 번호가 중복될 시 예외가 발생한다.")
    void validateDuplicatedNumberBetweenWinningAndBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        //given
        WinningLottoRequestBuilder winningLottoRequestBuilder = WinningLottoRequestBuilder.create();
        winningLottoRequestBuilder.winningNumbers(winningNumbers);
        //when
        //then
        Assertions.assertThatThrownBy(() -> winningLottoRequestBuilder.bonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 중복된 번호가 존재합니다.");
    }
}