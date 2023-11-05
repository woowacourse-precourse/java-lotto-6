package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("로또 당첨 등수 판단 기능")
    @ParameterizedTest
    @MethodSource("calculateLottoResultParameter")
    void calculateLottoResult(LottoAnswer lottoAnswer, LottoResult expected) {
        LottoNumberGenerator lottoNumberGenerator = () -> List.of(1, 2, 3, 4, 5, 6);
        LottoGenerator.generate(lottoNumberGenerator, 1)
                .stream()
                .map(lotto -> lotto.calcLottoResult(lottoAnswer))
                .forEach(Assertions::assertThat);
    }

    static Stream<Arguments> calculateLottoResultParameter() {
        return Stream.of(
                Arguments.of(new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7), LottoResult.FIRST_PRIZE),
                Arguments.of(new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7), LottoResult.SECOND_PRIZE),
                Arguments.of(new LottoAnswer(List.of(1, 2, 3, 4, 5, 8), 6), LottoResult.THIRD_PRIZE),
                Arguments.of(new LottoAnswer(List.of(1, 2, 3, 4, 8, 9), 7), LottoResult.FOURTH_PRIZE),
                Arguments.of(new LottoAnswer(List.of(1, 2, 3, 8, 9, 10), 7), LottoResult.FIFTH_PRIZE),
                Arguments.of(new LottoAnswer(List.of(1, 2, 8, 9, 10, 11), 7), LottoResult.PARTICIPATION_PRIZE),
                Arguments.of(new LottoAnswer(List.of(1, 8, 9, 10, 11, 12), 7), LottoResult.PARTICIPATION_PRIZE),
                Arguments.of(new LottoAnswer(List.of(8, 9, 10, 11, 12, 13), 7), LottoResult.PARTICIPATION_PRIZE)
        );
    }
}