package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 해당 번호가 포함되어있는지 확인하는 검사")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:true", "5:true", "6:true", "7:false"}, delimiter = ':')
    void containNumber(int number, boolean expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.isContain(number))
                .isEqualTo(expected);
    }

    @DisplayName("다른 로또와 비교후 같은 숫자의 개수를 조회하는지 확인하는 검사")
    @ParameterizedTest
    @MethodSource("generateData")
    void compareAnotherLotto(List<Integer> originalData, List<Integer> comparedData, int expected) {
        Lotto myLotto = new Lotto(originalData);
        Lotto another = new Lotto(comparedData);

        assertThat(myLotto.compareTo(another))
                .isEqualTo(expected);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(1, 2, 3, 4, 5, 6),6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(1, 2, 3, 4, 5, 7),5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(1, 2, 3, 4, 7, 8),4),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(1, 2, 3, 7, 8, 9),3),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(1, 2, 7, 8, 9, 10),2),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(1, 7, 8, 9, 10, 11),1),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6),Arrays.asList(7, 8, 9, 10, 11, 12),0)
        );
    }

}
