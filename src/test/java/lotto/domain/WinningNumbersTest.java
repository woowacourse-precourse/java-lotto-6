package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumbersTest {

    @ParameterizedTest(name = "당첨 번호 : {0}, 보너스 번호 : {1}")
    @MethodSource("generateDuplicateWinningNumbers")
    @DisplayName("보너스 번호가 당첨번호와 중복되면 예외가 발생한다.")
    void 보너스_번호가_당첨_번호와_중복_예외_테스트(WinningNumber winningNumber, BonusNumber bonusNumber) {
        //when, then
        Assertions.assertThatThrownBy(() -> new WinningNumbers(winningNumber, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("당첨 번호와 중복된");

    }

    @ParameterizedTest(name = "당첨 번호 : {0}, 로또 번호 : {1}")
    @MethodSource("generateLottoAndWinningNumber")
    @DisplayName("맞은 로또번호의 개수에 따라 등수를 반환한다.")
    void 등수_테스트(WinningNumber winning, List<Integer> lottoNumber, BonusNumber bonus,
                LottoResults expected) {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(winning, bonus);
        Lotto lotto = new Lotto(lottoNumber);

        //when
        LottoResults actual = winningNumbers.calculateLottoResult(lotto);

        //then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> generateDuplicateWinningNumbers() {
        return Stream.of(
                Arguments.of(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(6)),
                Arguments.of(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(2)),
                Arguments.of(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(3)),
                Arguments.of(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(4)));
    }

    static Stream<Arguments> generateLottoAndWinningNumber() {
        return Stream.of(Arguments.of(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)),
                        List.of(1, 2, 3, 4, 5, 12), new BonusNumber(12), LottoResults.SECOND),
                Arguments.of(new WinningNumber(List.of(1, 2, 3, 4, 5, 6)),
                        List.of(1, 2, 3, 4, 5, 12), new BonusNumber(21), LottoResults.THIRD),
                Arguments.of(new WinningNumber(List.of(1, 12, 13, 14, 15, 16)),
                        List.of(1, 13, 15, 16, 41, 45), new BonusNumber(41), LottoResults.FOURTH),
                Arguments.of(new WinningNumber(List.of(1, 31, 32, 33, 41, 45)),
                        List.of(1, 11, 12, 13, 21, 25), new BonusNumber(42), LottoResults.FAIL));
    }
}
