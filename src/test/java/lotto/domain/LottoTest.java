package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 번호 리스트 테스트")
class LottoTest {
    static Stream<Arguments> generateSizeExceptionData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5))
        );
    }

    static Stream<Arguments> generateDuplicateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 3, 5, 5)),
                Arguments.of(Arrays.asList(1, 1, 1, 1, 1, 1))
        );
    }


    static Stream<Arguments> generateCorrectData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(7, 8, 9, 10, 11, 12))
        );
    }


    @ParameterizedTest(name = "[{index}] 사이즈 예외 발생 : {0}")
    @MethodSource("generateSizeExceptionData")
    void 사이즈_예외_발생(List<Integer> list) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Lotto(list));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.WINNING_CNT.getMessage());
    }


    @ParameterizedTest(name = "[{index}] 중복값 존재 예외 발생 : {0}")
    @MethodSource("generateDuplicateData")
    void 중복값_존재_예외_발생(List<Integer> list) {
        // when
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Lotto(list));

        // then
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.DUPLICATE_NUM.getMessage());
    }


    @ParameterizedTest(name = "[{index}] 정상 생성 : {0}")
    @MethodSource("generateCorrectData")
    void 정상_생성(List<Integer> list) {
        // when
        Lotto lotto = new Lotto(list);

        // then
        assertThat(lotto.getNumbers().size()).isEqualTo(list.size());
    }


}