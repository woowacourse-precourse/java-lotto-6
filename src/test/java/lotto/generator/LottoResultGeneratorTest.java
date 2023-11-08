package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.domain.result.LottoResult;
import lotto.option.EqualStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultGeneratorTest {
    @DisplayName("LottoResult의 EqualStatus를 주어진 수에 맞게 설정하는지 확인한다.")
    @ParameterizedTest
    @MethodSource("validParameters")
    void setEqualStatusByCount(int equalCount, int bonusCount, EqualStatus equalStatus) {
        //given
        //when
        LottoResult lottoResult = LottoResultGenerator.setEqualStatus(equalCount, bonusCount);

        //then
        assertThat(lottoResult).isEqualTo(new LottoResult(equalStatus));
    }

    static Stream<Arguments> validParameters() {
        return Stream.of(
                Arguments.of(2, 1, EqualStatus.THREE_EQUAL),
                Arguments.of(5, 1, EqualStatus.FIVE_AND_BONUS_EQUAL)
        );
    }
}
