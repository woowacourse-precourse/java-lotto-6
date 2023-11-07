package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @DisplayName("보너스 번호가 정상적으로 들어왔을 때 보너스 넘버 객체가 반환된다.")
    @Test
    void bonusNumberCreateTest() {
        //given
        Integer number = 5;

        //when
        BonusNumber bonusNumber = BonusNumber.of(number);

        //then
        assertThat(bonusNumber)
                .usingRecursiveComparison()
                .isEqualTo(BonusNumber.of(number));
    }

    @DisplayName("보너스 번호가 정해진 범위를 넘어서면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void createBonusLottoNumberByOverRange() {
        assertThatThrownBy(() -> BonusNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 넘버가 List안에 들어있으면 true를 반환")
    @Test
    void containsIn() {
        //given
        BonusNumber bonusNumber = BonusNumber.of(5);
        List<Integer> lotto = List.of(1, 2, 3, 4, 5, 6);

        //when,then
        assertThat(bonusNumber.containsIn(lotto)).isTrue();
    }

    @DisplayName("보너스 넘버가 List안에 없으면 flase 반환")
    @Test
    void NotContainsIn() {
        //given
        BonusNumber bonusNumber = BonusNumber.of(5);
        List<Integer> lotto = List.of(1, 2, 3, 4, 9, 6);

        //when,then
        assertThat(bonusNumber.containsIn(lotto)).isFalse();
    }
}