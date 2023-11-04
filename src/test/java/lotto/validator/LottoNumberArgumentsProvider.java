package lotto.validator;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class LottoNumberArgumentsProvider {

    static Stream<Arguments> provideCorrectInput() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6"),
                Arguments.of("7,8,9,10,11,12"),
                Arguments.of("13,14,15,16,17,18"),
                Arguments.of("19,20,21,22,23,24"),
                Arguments.of("25,26,27,28,29,30"),
                Arguments.of("31,32,33,34,35,36"),
                Arguments.of("37,38,39,40,41,42"),
                Arguments.of("42,43,44,45,1,2")
        );
    }

    static Stream<Arguments> provideExceptionInput() {
        return Stream.of(
                Arguments.of(""), //빈 문자열
                Arguments.of("aaa"), //문자
                Arguments.of("!@$"), //특수 문자
                Arguments.of("안녕"), //한글
                Arguments.of("1,2,3"), //입력 양식 예외1
                Arguments.of("1,2,3,4,5,6,7"), //입력 양식 예외2
                Arguments.of("1,2,3,4,5,6,"), //입력 양식 예외3
                Arguments.of(",1,2,3,4,5,6"), //입력 양식 예외4
                Arguments.of("1,2,3,4,5,46"), //숫자 범위 예외5
                Arguments.of("1,1,2,3,4,5") //숫자 중복 예외
        );
    }
}
