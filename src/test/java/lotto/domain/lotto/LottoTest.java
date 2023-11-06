package lotto.domain.lotto;

import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("로또 번호가 1에서 45사이가 아니라면 예외가 발생한다.")
    void 로또_생성_시_예외_발생() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 46, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 중복되지 않고 1에서 45사이의 숫자 6개라면 예외 없이 생성된다.")
    void 로또_생성_시_예외_발생하지_않고_성공() {
        //given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        Assertions.assertDoesNotThrow(() -> new Lotto(numbers));
    }

    @ParameterizedTest(name = "로또 번호가 1,2,3,4,5,6 일때 보너스번호가 {0}이라면 결과 {1}")
    @DisplayName("로또가 보너스 번호를 가지고 있다면 True 없다면 False")
    @CsvSource(value = {"1,true", "7,false"})
    void 로또가_보너스번호_가지고_있는지_여부_테스트(int number, boolean expected) {
        // given
        BonusNumber bonusNumber = new BonusNumber(number);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // when
        boolean hasBonusNumber = lotto.hasSameNumber(bonusNumber);

        // then
        assertThat(hasBonusNumber).isEqualTo(expected);
    }

    @ParameterizedTest(name = "Lotto 번호 {0} 과 Lotto 번호 {1}을 비교했을때 결과는 {2}")
    @DisplayName("두개의 로또를 비교하여 몇개가 일치하는지 확인")
    @MethodSource("argumentsLottoMatchCount")
    void 로또번호_비교_시_일치_개수_테스트(List<Integer> numbers, List<Integer> otherNumbers, int expected) {
        Lotto lotto = new Lotto(numbers);
        Lotto otherLotto = new Lotto(otherNumbers);
        assertThat(lotto.calculateMatchCount(otherLotto)).isEqualTo(expected);
    }

    public static Stream<Arguments> argumentsLottoMatchCount() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7),
                        List.of(1, 2, 3, 4, 5, 6), 5),
                Arguments.of(List.of(1, 2, 3, 4, 8, 7),
                        List.of(1, 2, 3, 4, 5, 6), 4),
                Arguments.of(List.of(1, 2, 3, 7, 8, 9),
                        List.of(1, 2, 3, 4, 5, 6), 3),
                Arguments.of(List.of(1, 2, 7, 8, 9, 10),
                        List.of(1, 2, 3, 4, 5, 6), 2),
                Arguments.of(List.of(1, 7, 8, 9, 10, 11),
                        List.of(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12),
                        List.of(1, 2, 3, 4, 5, 6), 0)
        );
    }
}