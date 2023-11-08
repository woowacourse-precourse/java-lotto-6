package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("WinningNumbers 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class WinningNumbersTest {

    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndLotto")
    void 생성자는_문자열이_주어지면_구분자를_기준으로_잘라_로또객체를_생성한다(String winningNumbers, List<Integer> lottoNumbers) {
        WinningNumbers testWinningNumbers = new WinningNumbers(winningNumbers);
        List<LottoNumber> testLotto = lottoNumbers.stream().map(LottoNumber::new).toList();

        Assertions.assertTrue(isEquals(testWinningNumbers, testLotto));
    }

    private static Stream<Arguments> provideWinningNumbersAndLotto() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("12,23,34,45,5,6", List.of(12, 23, 34, 45, 5, 6))
        );
    }

    private boolean isEquals(WinningNumbers testWinningNumbers, List<LottoNumber> testLotto) {
        return IntStream.range(0, 6)
                .allMatch(i -> testWinningNumbers.isContain(testLotto.get(i)));
    }
}
