package lotto.model.domain.result;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.domain.lotto.Lotto;
import lotto.model.domain.lotto.LottoAnswer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultFactoryTest {

    ResultFactory factory = new ResultFactory();

    @ParameterizedTest
    @MethodSource("resultArgs")
    void 올바른_Result_생성_테스트(Lotto lotto, LottoAnswer answer, LottoResult result) {
        LottoResult factoryResult = factory.getResult(lotto, answer);
        Assertions.assertThat(factoryResult)
                .isEqualTo(result);
    }

    static Stream<Arguments> resultArgs() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7),
                        LottoResult.FIRST),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7),
                        LottoResult.SECOND),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                        new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7),
                        LottoResult.THIRD),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 9, 10)),
                        new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7),
                        LottoResult.FOURTH),

                Arguments.of(new Lotto(List.of(1, 2, 3, 9, 10, 11)),
                        new LottoAnswer(List.of(1, 2, 3, 4, 5, 6), 7),
                        LottoResult.FIFTH),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(8, 9, 10, 11, 12, 13), 7),
                        LottoResult.LOSE),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(6, 9, 10, 11, 12, 13), 7),
                        LottoResult.LOSE),

                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new LottoAnswer(List.of(5, 6, 10, 11, 12, 13), 7),
                        LottoResult.LOSE)
        );
    }

}