package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.NumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningResultTest {
    NumbersGenerator numbersGenerator = () -> List.of(1, 2, 3, 4, 5, 6);

    @DisplayName("전체 로또와 , 당첨 번호를 통해 몇등이 몇개 당첨됐는지를 계산함")
    @ParameterizedTest
    @MethodSource("generate")
    void calculateWinningTest(List<Integer> numbers, int bonusNumber, Rank rank) {
        //given
        Lottos lottos1 = new Lottos(1000, numbersGenerator);
        WinningNumbers winningNumbers = new WinningNumbers(numbers);
        winningNumbers.setBonusNumber(bonusNumber);

        WinningResult winningResult = new WinningResult();
        winningResult.calculateWinning(lottos1, winningNumbers);

        //when
        int firstCount = winningResult.getWinningCount(rank);

        //then
        assertEquals(1, firstCount);
    }

    static Stream<Arguments> generate() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7, Rank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 45), 6, Rank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 45), 43, Rank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 42, 45), 43, Rank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 41, 42, 45), 43, Rank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 40, 41, 42, 45), 43, Rank.BLANK)
        );
    }

    @DisplayName("당첨에 따른 수익률을 계산며")
    @Test
    void calculateEarningRateTest() {
        //given
        Lottos lottos = new Lottos(1000, numbersGenerator);
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        winningNumbers.setBonusNumber(7);
        WinningResult winningResult = new WinningResult();
        winningResult.calculateWinning(lottos, winningNumbers);

        //when
        float earningRate = winningResult.calculateEarningRate(lottos);

        //then
        assertEquals(200000000, earningRate);
    }

}
