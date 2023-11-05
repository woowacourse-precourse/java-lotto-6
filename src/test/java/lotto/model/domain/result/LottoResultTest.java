package lotto.model.domain.result;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("toStringArgs")
    void toStringTest(LottoResult result, String toStringResult){
        Assertions.assertThat(result.toString())
                .isEqualTo(toStringResult);
    }

    static Stream<Arguments> toStringArgs(){
        return Stream.of(
                Arguments.of(LottoResult.FIRST, "6개 일치 (2,000,000,000원)"),
                Arguments.of(LottoResult.SECOND, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
                Arguments.of(LottoResult.THIRD, "5개 일치 (1,500,000원)"),
                Arguments.of(LottoResult.FOURTH, "4개 일치 (50,000원)"),
                Arguments.of(LottoResult.FIFTH, "3개 일치 (5,000원)")
        );
    }
}