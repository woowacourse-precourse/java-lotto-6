package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.constants.LottoRanks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class OutputViewTest {
    private final OutputView sample = new OutputView();

    @ParameterizedTest
    @DisplayName("발행한 로또 수량에 관한 문자열이 실행 결과 출력 예시와 같은 문자열 형식인지 확인")
    @CsvSource(value = {
            "2, '\n2개를 구매했습니다.'", "2000, '\n2,000개를 구매했습니다.'",
            "2000000, '\n2,000,000개를 구매했습니다.'", "2000000000, '\n2,000,000,000개를 구매했습니다.'"
    })
    void convertQuantityToString_test(int input, String expected) {
        assertThat(sample.convertQuantityToString(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("1개의 로또 번호에 관한 문자열이 실행 결과 출력 예시와 같은 문자열 형식을 갖는지 확인")
    @MethodSource("sampleLottoNumber")
    void convertLottoNumToString_test(List<Integer> inputLottoNum, String expected) {
        assertThat(sample.convertLottoNumToString(inputLottoNum)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("당첨등수별 로또 개수에 관한 문자열이 실행 결과 출력 예시와 동일하면서 당첨금과 당첨 개수에 천 단위마다 쉼표 사용")
    @MethodSource("sampleLottoRanksAndCountString")
    void convertCountsToString_test(LottoRanks rank, int count, String expected) {
        assertThat(sample.convertCountsToString(rank, count)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("당첨 등수가 2등인지, 그 이외 등수인지에 따라 지정된 서로 다른 문자열 형식을 갖추는지 확인")
    @MethodSource("sampleLottoRanksAndFormat")
    void appendFormat_test(LottoRanks rank, String expected) {
        assertThat(sample.appendFormat(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("총 수익률 출력 시 수익률이 소수점 이하 둘째자리에서 반올림되고, 정수 부분에서는 천 단위마다 콤마를 사용하는지 확인")
    @MethodSource("sampleReturnRateAndExpected")
    void convertReturnRateToString_test(double inputReturnRate, String expected) {
        assertThat(sample.convertReturnRateToString(inputReturnRate)).isEqualTo(expected);
    }

    private static Stream<Arguments> sampleLottoNumber() {
        return Stream.of(
                Arguments.of(List.of(8, 21, 23, 41, 42, 43), "[8, 21, 23, 41, 42, 43]"),
                Arguments.of(List.of(3, 5, 11, 16, 32, 38), "[3, 5, 11, 16, 32, 38]"),
                Arguments.of(List.of(7, 11, 16, 35, 36, 44), "[7, 11, 16, 35, 36, 44]")
        );
    }
    private static Stream<Arguments> sampleLottoRanksAndCountString() {
        return Stream.of(
                Arguments.of(LottoRanks.FIFTH, 1000, "3개 일치 (5,000원) - 1,000개\n"),
                Arguments.of(LottoRanks.FOURTH, 1000, "4개 일치 (50,000원) - 1,000개\n"),
                Arguments.of(LottoRanks.THIRD, 1000, "5개 일치 (1,500,000원) - 1,000개\n"),
                Arguments.of(LottoRanks.SECOND, 1000, "5개 일치, 보너스 볼 일치 (30,000,000원) - 1,000개\n"),
                Arguments.of(LottoRanks.FIRST, 1000, "6개 일치 (2,000,000,000원) - 1,000개\n")
        );
    }
    private static Stream<Arguments> sampleLottoRanksAndFormat() {
        return Stream.of(
                Arguments.of(LottoRanks.THIRD, "%d개 일치 (%,d원) - %,d개\n"),
                Arguments.of(LottoRanks.SECOND, "%d개 일치, 보너스 볼 일치 (%,d원) - %,d개\n")
        );
    }
    private static Stream<Arguments> sampleReturnRateAndExpected() {
        return Stream.of(
                Arguments.of(31.25, "총 수익률은 31.3%입니다.\n"),
                Arguments.of(200000000, "총 수익률은 200,000,000.0%입니다.\n")
        );
    }
}