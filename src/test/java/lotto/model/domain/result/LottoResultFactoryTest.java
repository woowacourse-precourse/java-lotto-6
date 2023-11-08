package lotto.model.domain.result;

import java.util.stream.Stream;
import lotto.model.domain.result.compare.LottoAnswerCompareResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultFactoryTest {

    LottoResultFactory factory = new LottoResultFactory();

    @ParameterizedTest
    @MethodSource("resultArgs")
    void 올바른_Result_생성_테스트(LottoAnswerCompareResult compareResult, LottoResult result) {
        LottoResult factoryResult = factory.getLottoResult(compareResult);
        Assertions.assertThat(factoryResult)
                .isEqualTo(result);
    }

    static Stream<Arguments> resultArgs() {
        return Stream.of(
                Arguments.of(new LottoAnswerCompareResult(6, false),
                        LottoResult.FIRST),

                Arguments.of(new LottoAnswerCompareResult(5, true),
                        LottoResult.SECOND),

                Arguments.of(new LottoAnswerCompareResult(5, false),
                        LottoResult.THIRD),

                Arguments.of(new LottoAnswerCompareResult(4, false),
                        LottoResult.FOURTH),

                Arguments.of(new LottoAnswerCompareResult(3, false),
                        LottoResult.FIFTH),

                Arguments.of(new LottoAnswerCompareResult(2, false),
                        LottoResult.LOSE),

                Arguments.of(new LottoAnswerCompareResult(1, false),
                        LottoResult.LOSE),

                Arguments.of(new LottoAnswerCompareResult(0, false),
                        LottoResult.LOSE)
        );
    }

}