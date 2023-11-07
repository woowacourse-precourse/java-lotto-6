package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class EarningRateTest {
    @ParameterizedTest
    @MethodSource("generateData")
    void 수익률_계산_테스트(int amount, List<Score> earning, String expected) {
        EarningRate earningRate = new EarningRate(amount, earning);
        assertEquals(earningRate.toString(), expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(8000, List.of(Score.Fifth), "62.5%"),
                Arguments.of(5000, List.of(Score.Fifth), "100.0%"),
                Arguments.of(200000, List.of(Score.First), "1,000,000.0%"),
                Arguments.of(50025, List.of(Score.Fourth), "100.0%"),
                Arguments.of(50274, List.of(Score.Fourth), "99.5%"));
    }
}
