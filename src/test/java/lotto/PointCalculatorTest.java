package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointCalculatorTest {
    @ParameterizedTest
    @CsvSource(value = {"'1,2,3,4,5,6', '1,2,3,4,5,6', 7, 6.0", "'1,2,3,4,5,6', '1,2,3,4,5,7', 6, 5.5",
            "'1,2,3,4,5,6', '1,2,3,4,5,7', 10, 5.0"}, delimiter = ',')
    void pointCalculatorTest(String lottoNumbers, String answerLottoNumbers, int bonusNumber, double expectedResult) {

        //Given
        Lotto lotto = new Lotto(Arrays.stream(lottoNumbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
        AnswerLotto answerLotto = new AnswerLotto(Arrays.stream(answerLottoNumbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList()));
        PointCalculator pointCalculator = new PointCalculator();

        //When
        double result = pointCalculator.calculateTotalPoint(lotto, answerLotto,
                new BonusNumber(bonusNumber, answerLotto));

        //Then
        assertThat(result).isEqualTo(expectedResult);
    }
}
