package lotto.model;

import java.util.stream.Stream;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 1장을 발행했을 시 6개의 로또 번호는 오름차순 정렬된다.")
    @ParameterizedTest
    @MethodSource("samplePurchasedLottoNumber")
    void getSingleLotto_test(List<Integer> input, List<Integer> expected) {
        assertEquals(Lotto.getSingleLotto(input), expected);
    }

    private static Stream<Arguments> samplePurchasedLottoNumber() {
        return Stream.of(
                Arguments.of(List.of(41, 21, 43, 8, 23, 42), List.of(8, 21, 23, 41, 42, 43)),
                Arguments.of(List.of(3, 5, 11, 38, 32, 16), List.of(3, 5, 11, 16, 32, 38)),
                Arguments.of(List.of(44, 36, 35, 16, 11, 7), List.of(7, 11, 16, 35, 36, 44))
        );
    }
}