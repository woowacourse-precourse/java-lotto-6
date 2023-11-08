package lotto.domain;

import lotto.dto.LottoWinningResultDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoResultTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void LottoResultTest_객체_생성(List<Integer> inputNumbers, int inputNumber) {
        assertThat(LottoResult.create(new Lotto(inputNumbers), BonusNumber.create(inputNumber)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 당첨_로또_번호와_보너스_번호가_중복되면_예외가_발생한다(int input) {
        assertThatThrownBy(() -> LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.create(input)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    void 로또_당첨_결과를_반환한다() {
        var lottoResult = LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.create(7));
        var lottos = List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        assertThat(lottoResult.calculateResult(lottos).lottoWinningResultDTOs())
                .isEqualTo(
                        List.of(
                                new LottoWinningResultDTO(0, false),
                                new LottoWinningResultDTO(3, false),
                                new LottoWinningResultDTO(4, false),
                                new LottoWinningResultDTO(5, false),
                                new LottoWinningResultDTO(5, true),
                                new LottoWinningResultDTO(6, false)
                        )
                );
    }

    @Test
    void 로또_당첨_수익률을_반환한다() {
        var lottoResult = LottoResult.create(new Lotto(List.of(1, 2, 3, 4, 5, 6)), BonusNumber.create(7));
        var lottos = List.of(
                new Lotto(List.of(10, 11, 12, 13, 14, 15)),
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 10, 11)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        assertThat(lottoResult.calculateResult(lottos).lottoReturnsRateDTO().lottoReturnsRate())
                .isEqualTo(3.385925E7);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7),
                Arguments.of(List.of(11, 12, 13, 14, 15, 16), 17),
                Arguments.of(List.of(21, 22, 23, 24, 25, 26), 27),
                Arguments.of(List.of(31, 32, 33, 34, 35, 36), 28)
        );
    }
}
