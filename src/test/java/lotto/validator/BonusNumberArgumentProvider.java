package lotto.validator;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.lotto.Lotto;
import org.junit.jupiter.params.provider.Arguments;

public class BonusNumberArgumentProvider {

    static Stream<Arguments> provideCorrectInput() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), "7"),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), "13"),
                Arguments.of(new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)), "19"),
                Arguments.of(new Lotto(Arrays.asList(20, 21, 22, 23, 24, 25)), "26"),
                Arguments.of(new Lotto(Arrays.asList(26, 27, 28, 29, 30, 31)), "32"),
                Arguments.of(new Lotto(Arrays.asList(32, 33, 34, 35, 36, 37)), "38"),
                Arguments.of(new Lotto(Arrays.asList(39, 40, 41, 42, 43, 44)), "45")
        );
    }

    static Stream<Arguments> provideExceptionInput() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), ""), //빈 문자열
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), "aaa"), //문자
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), "!@$"), //특수 문자
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), "안녕"), //한글
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), "46"), //숫자 범위 예외
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), "1") //숫자 중복 예외
        );
    }
}
