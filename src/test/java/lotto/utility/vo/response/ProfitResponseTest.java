package lotto.utility.vo.response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.stream.Stream;
import lotto.vo.response.ProfitResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProfitResponseTest {

    @ParameterizedTest
    @MethodSource("수익률_설정")
    void 수익률을_올바른_형식으로_출력한다(double 수익률, String 출력내용) {
        ProfitResponse 수익률_응답 = new ProfitResponse(수익률);

        // then
        assertThat(수익률_응답.createMessage()).contains(출력내용);
    }

    static Stream<Arguments> 수익률_설정() {
        return Stream.of(
            Arguments.arguments(62.5, "총 수익률은 62.5%입니다."),
            Arguments.arguments(62.0, "62.0%"),
            Arguments.arguments(62.9, "62.9%"),
            Arguments.arguments(62.1, "62.1%")

        );
    }
}