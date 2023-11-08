package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class ProfitTest {
    @ParameterizedTest
    @MethodSource("당첨내역_설정")
    void 등수목록으로_수익률을_계산한다(List<Rank> 등수목록, String 계산결과) {
        // when
        Profit 수익률 = new Profit(등수목록);

        // then
        String 수익률_출력_메세지 = 수익률.convertResponse().createMessage();
        assertThat(수익률_출력_메세지).contains(계산결과);
    }

    static Stream<Arguments> 당첨내역_설정() {
        return Stream.of(
            Arguments.arguments(List.of(Rank.FIFTH, Rank.UNRANKED, Rank.UNRANKED, Rank.UNRANKED), "125.0%"),
            Arguments.arguments(List.of(Rank.FIFTH, Rank.FIRST, Rank.UNRANKED, Rank.UNRANKED), "50,000,125.0%"),
            Arguments.arguments(List.of(Rank.UNRANKED, Rank.UNRANKED, Rank.UNRANKED, Rank.UNRANKED), "0.0%"),
            Arguments.arguments(List.of(Rank.FOURTH, Rank.FOURTH, Rank.UNRANKED, Rank.UNRANKED), "2,500.0%"),
            Arguments.arguments(List.of(Rank.THIRD, Rank.UNRANKED, Rank.UNRANKED), "50,000.0%")
        );
    }
}