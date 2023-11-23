package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.entity.Lotto;
import lotto.domain.lotto.entity.LottoAnswer;
import lotto.domain.lotto.entity.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @Nested
    @DisplayName("로또 결과 확인")
    class 결과_테스트 {

        @ParameterizedTest(name = "결과 {0} 테스트")
        @MethodSource("lottoAndResult")
        @DisplayName("[SUCCESS] 로또 정답과 로또를 비교한 결과를 확인한다.")
        void 결과_테스트(Lotto lotto, LottoResult expectedResult) {
            LottoAnswer lottoAnswer =
                    new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7);
            Assertions.assertThat(LottoResult.getResult(lottoAnswer, lotto))
                    .isEqualTo(expectedResult);
        }

        static Stream<Arguments> lottoAndResult() {
            return Stream.of(
                    Arguments.of(
                            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                            LottoResult.FIRST
                    ),
                    Arguments.of(
                            new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                            LottoResult.SECOND
                    ),
                    Arguments.of(
                            new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                            LottoResult.THIRD
                    ),
                    Arguments.of(
                            new Lotto(List.of(1, 2, 3, 4, 7, 8)),
                            LottoResult.FOURTH
                    ),
                    Arguments.of(
                            new Lotto(List.of(1, 2, 3, 7, 8, 9)),
                            LottoResult.FIFTH
                    ),
                    Arguments.of(
                            new Lotto(List.of(1, 2, 7, 8, 9, 10)),
                            LottoResult.LOSE
                    ),
                    Arguments.of(
                            new Lotto(List.of(1, 7, 8, 9, 10, 11)),
                            LottoResult.LOSE
                    ),
                    Arguments.of(
                            new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                            LottoResult.LOSE
                    )
            );
        }
    }

}