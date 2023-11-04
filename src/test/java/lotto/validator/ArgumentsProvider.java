package lotto.validator;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class ArgumentsProvider {

    static Stream<Arguments> provideCorrectInput() {
        return IntStream.rangeClosed(1, 1000)
                .mapToObj(num -> Arguments.of(num + "000"));
    }

    static Stream<Arguments> provideExceptionInput() {
        return Stream.concat(
                Stream.of(
                        Arguments.of(""), //빈 문자열
                        Arguments.of("aaa"), //문자
                        Arguments.of("!@$"), //특수 문자
                        Arguments.of("안녕") //한글
                ),
                Stream.concat(
                        IntStream.rangeClosed(1, 999)
                                .mapToObj(num -> Arguments.of(String.valueOf(num))), //1000으로 나누어 떨어지지 않는 수
                        IntStream.rangeClosed(1001, 2000)
                                .mapToObj(num -> Arguments.of(num + "000")) //허용 구매 범위 밖의 수
                )
        );
    }
}
