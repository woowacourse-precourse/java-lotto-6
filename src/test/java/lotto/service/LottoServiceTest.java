package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @DisplayName("로또 번호 3개 일치일 때 통과")
    @ParameterizedTest
    @MethodSource("winningTestCase")
    public void getWinningTest(int expectedLottoCount, int expectedBonusCount, List<Integer> myLotto, List<Integer> lotto, int bonusNumber) throws Exception {
        //given
        LottoService lottoService = new LottoService();

        //when
        List<Integer> testWinningResult = lottoService.getWinning(myLotto, lotto, bonusNumber);

        //then
        assertThat(testWinningResult).isEqualTo(Arrays.asList(expectedLottoCount, expectedBonusCount));
    }

    private static Stream<Arguments> winningTestCase() {
        return Stream.of(
                Arguments.of(0, 0, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8, 9, 10), 11),
                Arguments.of(0, 1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7, 8, 9, 10), 5),
                Arguments.of(1, 1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 7, 8, 9, 10), 5),
                Arguments.of(2, 0, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 8, 9, 10), 11),
                Arguments.of(2, 1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 8, 9, 10), 5),
                Arguments.of(3, 0, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 9, 10), 11),
                Arguments.of(3, 1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 9, 10), 5),
                Arguments.of(4, 0, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 10), 11),
                Arguments.of(4, 1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 10), 5),
                Arguments.of(5, 0, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5), 11),
                Arguments.of(5, 1, Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 2, 3, 4, 5), 5),
                Arguments.of(6, 0, Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), 11)
        );
    }
}